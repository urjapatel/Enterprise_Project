package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.dto.*;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderController(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/orders/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/orders")
    public String placeOrderFromForm(@Valid @ModelAttribute("order") Order order, BindingResult br, Model model) {
        if (br.hasErrors()) return "orderForm";

        order.setOrderDate(LocalDateTime.now());
        Order saved = orderRepository.save(order);

        // Build request to market service
        MarketOrderRequest mor = new MarketOrderRequest(saved.getOrderId(), saved.getTickerSymbol(), saved.getQuantity(), saved.getOrderAmt(), saved.getOrderType());
        MarketOrderResponse marketResp = restTemplate.postForObject("http://market-service/api/market/orders", mor, MarketOrderResponse.class);

        // Reserve funds via account-service
        TransactionReserveRequest tres = new TransactionReserveRequest(saved.getOrderId(), saved.getOrderAmt(), saved.getTickerSymbol());
        TransactionReserveResponse tresp = restTemplate.postForObject("http://account-service/api/transactions/reserve", tres, TransactionReserveResponse.class);

        model.addAttribute("savedOrder", saved);
        model.addAttribute("marketResp", marketResp);
        model.addAttribute("transactionResp", tresp);
        return "success";
    }

    // REST API portion
    @RestController
    @RequestMapping("/api/orders")
    static class OrderApiController {
        private final OrderRepository repo;
        private final RestTemplate restTemplate;

        public OrderApiController(OrderRepository repo, RestTemplate restTemplate) {
            this.repo = repo;
            this.restTemplate = restTemplate;
        }

        @PostMapping
        public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
            order.setOrderDate(LocalDateTime.now());
            Order saved = repo.save(order);

            // notify market & account (fire-and-forget style; handle failures in production)
            MarketOrderRequest mor = new MarketOrderRequest(saved.getOrderId(), saved.getTickerSymbol(), saved.getQuantity(), saved.getOrderAmt(), saved.getOrderType());
            restTemplate.postForObject("http://market-service/api/market/orders", mor, MarketOrderResponse.class);

            TransactionReserveRequest tres = new TransactionReserveRequest(saved.getOrderId(), saved.getOrderAmt(), saved.getTickerSymbol());
            restTemplate.postForObject("http://account-service/api/transactions/reserve", tres, TransactionReserveResponse.class);

            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        @GetMapping
        public List<Order> list() { return repo.findAll(); }
    }
}
