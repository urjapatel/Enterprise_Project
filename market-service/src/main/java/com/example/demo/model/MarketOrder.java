package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "marketOrders")
public class MarketOrder {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("tickerSymbol")
    private String tickerSymbol;

    @JsonProperty("executedPrice")
    private Double executedPrice;

    @JsonProperty("exchangeType")
    private String exchangeType;

    @JsonProperty("confirmationStatus")
    private String confirmationStatus;

    public MarketOrder() {}

    public MarketOrder(Integer orderId, String tickerSymbol, Double executedPrice, String exchangeType, String confirmationStatus) {
        this.orderId = orderId;
        this.tickerSymbol = tickerSymbol;
        this.executedPrice = executedPrice;
        this.exchangeType = exchangeType;
        this.confirmationStatus = confirmationStatus;
    }

    // getters & setters...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public Double getExecutedPrice() { return executedPrice; }
    public void setExecutedPrice(Double executedPrice) { this.executedPrice = executedPrice; }
    public String getExchangeType() { return exchangeType; }
    public void setExchangeType(String exchangeType) { this.exchangeType = exchangeType; }
    public String getConfirmationStatus() { return confirmationStatus; }
    public void setConfirmationStatus(String confirmationStatus) { this.confirmationStatus = confirmationStatus; }
}
