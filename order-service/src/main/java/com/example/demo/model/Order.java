package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "orders")
public class Order {

    @Id
    @JsonProperty("id")
    private String id;

    @NotNull(message = "orderId required")
    @JsonProperty("orderId")
    private Integer orderId;

    @NotBlank(message = "tickerSymbol required")
    @JsonProperty("tickerSymbol")
    private String tickerSymbol;

    @NotNull(message = "quantity required")
    @Min(value = 1, message = "quantity must be >= 1")
    @JsonProperty("quantity")
    private Integer quantity;

    @NotNull(message = "orderAmt required")
    @JsonProperty("orderAmt")
    private Double orderAmt;

    @NotBlank(message = "orderType required")
    @JsonProperty("orderType")
    private String orderType; // BUY or SELL

    @JsonProperty("orderDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDate;

    @JsonProperty("attributes")
    private Map<String, String> attributes;

    public Order() {}

    public Order(Integer orderId, String tickerSymbol, Integer quantity, Double orderAmt, String orderType) {
        this.orderId = orderId;
        this.tickerSymbol = tickerSymbol;
        this.quantity = quantity;
        this.orderAmt = orderAmt;
        this.orderType = orderType;
    }

    // full getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }

    public Double getPricePerUnit() {
        if (quantity == null || quantity == 0 || orderAmt == null) return null;
        return orderAmt / quantity;
    }
}
