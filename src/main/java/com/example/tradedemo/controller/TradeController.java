package com.example.tradedemo.controller;

import com.example.tradedemo.model.Trade;
import com.example.tradedemo.service.TradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {

        this.tradeService = tradeService;
    }

    @GetMapping
    public List<Trade> getTrades() {

        return tradeService.getAllTrades();
    }

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {

        return tradeService.addTrade(trade);
    }
}
