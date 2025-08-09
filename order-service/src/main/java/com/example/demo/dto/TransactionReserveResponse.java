package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReserveResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("feeAmt")
    private Double feeAmt;
    @JsonProperty("reservedAmount")
    private Double reservedAmount;

    public TransactionReserveResponse() {}

    public TransactionReserveResponse(String status, String transactionId, Double feeAmt, Double reservedAmount) {
        this.status = status;
        this.transactionId = transactionId;
        this.feeAmt = feeAmt;
        this.reservedAmount = reservedAmount;
    }

    // getters & setters...
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public Double getFeeAmt() { return feeAmt; }
    public void setFeeAmt(Double feeAmt) { this.feeAmt = feeAmt; }
    public Double getReservedAmount() { return reservedAmount; }
    public void setReservedAmount(Double reservedAmount) { this.reservedAmount = reservedAmount; }
    
    @Override
    public String toString() {
        return "TransactionReserveResponse{" +
                "status='" + status + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", feeAmt=" + feeAmt +
                ", reservedAmount=" + reservedAmount +
                '}';
    }
}
