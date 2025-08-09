package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.MarketOrder;

@Repository
public interface MarketOrderRepository extends MongoRepository<MarketOrder, String> {}
