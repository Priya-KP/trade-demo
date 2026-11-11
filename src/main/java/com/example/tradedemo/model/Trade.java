package com.example.tradedemo.model;

import java.math.BigDecimal;

public record Trade(
                String tradeId,
                String accountId,
                String currencyPair,
                String side,
                BigDecimal amount,
                BigDecimal rate,
                String status) {
}
