package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TransactionReserveRequest;
import com.example.demo.dto.TransactionReserveResponse;
import com.example.demo.model.AcctTransaction;
import com.example.demo.repository.TransactionRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/reserve")
    public ResponseEntity<TransactionReserveResponse> reserve(@Valid @RequestBody TransactionReserveRequest req) {
        Double fee = 0.0;
        if (req.getOrderAmt() != null) {
            fee = req.getOrderAmt() * 0.001; // 0.1%
        }
        Double reserved = (req.getOrderAmt() == null) ? 0.0 : (req.getOrderAmt() - fee);

        AcctTransaction t = new AcctTransaction();
        t.setOrderId(req.getOrderId());
        t.setTransactionType("RESERVE");
        t.setTickerSymbol(req.getTickerSymbol());
        t.setOrderAmt(req.getOrderAmt());
        t.setOrderDateTime(LocalDateTime.now());
        t.setFeeAmt(fee);
        t.setBalanceAmt(reserved);

        AcctTransaction saved = repo.save(t);
        TransactionReserveResponse resp = new TransactionReserveResponse("RESERVED", saved.getId(), fee, reserved);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AcctTransaction> list() {
        return repo.findAll();
    }
}
