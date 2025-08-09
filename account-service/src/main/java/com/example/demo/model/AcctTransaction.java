package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "transactions")
public class AcctTransaction {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("transactionType")
    private String transactionType; // RESERVE, CONFIRM

    @JsonProperty("tickerSymbol")
    private String tickerSymbol;

    @JsonProperty("transactionPrice")
    private Double transactionPrice;

    @JsonProperty("orderDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDateTime;

    @JsonProperty("orderAmt")
    private Double orderAmt;

    @JsonProperty("balanceAmt")
    private Double balanceAmt;

    @JsonProperty("feeAmt")
    private Double feeAmt;

    public AcctTransaction() {}

    // getters & setters...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public Double getTransactionPrice() { return transactionPrice; }
    public void setTransactionPrice(Double transactionPrice) { this.transactionPrice = transactionPrice; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(LocalDateTime orderDateTime) { this.orderDateTime = orderDateTime; }
    public Double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(Double orderAmt) { this.orderAmt = orderAmt; }
    public Double getBalanceAmt() { return balanceAmt; }
    public void setBalanceAmt(Double balanceAmt) { this.balanceAmt = balanceAmt; }
    public Double getFeeAmt() { return feeAmt; }
    public void setFeeAmt(Double feeAmt) { this.feeAmt = feeAmt; }
}
