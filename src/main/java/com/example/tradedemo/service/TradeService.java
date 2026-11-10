package com.example.tradedemo.service;

import com.example.tradedemo.model.Trade;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {
    private final List<Trade> trades = new ArrayList<>();

    public TradeService() {
        trades.add(new Trade(
                "T1001", "A999", "EUR/USD", "BUY",
                new BigDecimal("1000000"), new BigDecimal("1.10")
        ));
    }

    public List<Trade> getAllTrades() {
        return trades;
    }

    public Trade addTrade(Trade trade) {
        trades.add(trade);
        return trade;
    }
}
