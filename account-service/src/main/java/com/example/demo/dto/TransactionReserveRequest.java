package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class TransactionReserveRequest {
    @JsonProperty("orderId")
    @NotNull(message = "orderId required")
    private Integer orderId;

    @JsonProperty("orderAmt")
    @NotNull(message = "orderAmt required")
    private Double orderAmt;

    @JsonProperty("tickerSymbol")
    private String tickerSymbol;

    public TransactionReserveRequest() {}

    public TransactionReserveRequest(Integer orderId, Double orderAmt, String tickerSymbol) {
        this.orderId = orderId;
        this.orderAmt = orderAmt;
        this.tickerSymbol = tickerSymbol;
    }

    // getters & setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public Double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(Double orderAmt) { this.orderAmt = orderAmt; }
    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
}
