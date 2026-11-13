package com.example.tradedemo.dto;

import java.math.BigDecimal;

public class TradeResponse {

    private String tradeId;
    private String accountId;
    private String currencyPair;
    private String side;
    private BigDecimal amount;
    private BigDecimal rate;
    private String status;

    public TradeResponse(String tradeId,
                         String accountId,
                         String currencyPair,
                         String side,
                         BigDecimal amount,
                         BigDecimal rate,
                         String status) {
        this.tradeId = tradeId;
        this.accountId = accountId;
        this.currencyPair = currencyPair;
        this.side = side;
        this.amount = amount;
        this.rate = rate;
        this.status = status;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public String getSide() {
        return side;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getStatus() {
        return status;
    }
}