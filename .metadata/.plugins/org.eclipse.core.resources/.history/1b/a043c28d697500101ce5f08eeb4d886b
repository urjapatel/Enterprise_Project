package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MarketOrderRequest;
import com.example.demo.dto.MarketOrderResponse;
import com.example.demo.model.MarketOrder;
import com.example.demo.repository.MarketOrderRepository;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    private final MarketOrderRepository repo;

    public MarketController(MarketOrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/orders")
    public ResponseEntity<MarketOrderResponse> placeOrder(@Valid @RequestBody MarketOrderRequest req) {
        double executedPrice = 0.0;
        if (req.getOrderAmt() != null && req.getQuantity() != null && req.getQuantity() != 0) {
            executedPrice = req.getOrderAmt() / req.getQuantity();
        }
        MarketOrder mo = new MarketOrder(req.getOrderId(), req.getTickerSymbol(), executedPrice, "NYSE", "CONFIRMED");
        MarketOrder saved = repo.save(mo);
        MarketOrderResponse resp = new MarketOrderResponse(saved.getId(), saved.getConfirmationStatus(), saved.getExecutedPrice());
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public List<MarketOrder> listOrders() {
        return repo.findAll();
    }
}
