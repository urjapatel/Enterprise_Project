package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MarketOrderRequest {
    @JsonProperty("orderId")
    @NotNull(message = "orderId required")
    private Integer orderId;

    @JsonProperty("tickerSymbol")
    @NotBlank(message = "tickerSymbol required")
    private String tickerSymbol;

    @JsonProperty("quantity")
    @NotNull(message = "quantity required")
    @Min(value = 1, message = "quantity >= 1")
    private Integer quantity;

    @JsonProperty("orderAmt")
    @NotNull(message = "orderAmt required")
    private Double orderAmt;

    @JsonProperty("orderType")
    @NotBlank(message = "orderType required")
    private String orderType;

    public MarketOrderRequest() {}

    public MarketOrderRequest(Integer orderId, String tickerSymbol, Integer quantity, Double orderAmt, String orderType) {
        this.orderId = orderId;
        this.tickerSymbol = tickerSymbol;
        this.quantity = quantity;
        this.orderAmt = orderAmt;
        this.orderType = orderType;
    }

    // getters & setters...
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(Double orderAmt) { this.orderAmt = orderAmt; }
    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
}
