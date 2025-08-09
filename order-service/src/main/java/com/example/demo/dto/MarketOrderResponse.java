package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketOrderResponse {
    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("executedPrice")
    private Double executedPrice;

    public MarketOrderResponse() {}

    public MarketOrderResponse(String transactionId, String status, Double executedPrice) {
        this.transactionId = transactionId;
        this.status = status;
        this.executedPrice = executedPrice;
    }

    // getters & setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getExecutedPrice() { return executedPrice; }
    public void setExecutedPrice(Double executedPrice) { this.executedPrice = executedPrice; }
    
    @Override
    public String toString() {
        return "MarketOrderResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", status='" + status + '\'' +
                ", executedPrice=" + executedPrice +
                '}';
    }
}
