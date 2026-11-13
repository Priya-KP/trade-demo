package com.example.tradedemo.controller;

import com.example.tradedemo.dto.TradeRequest;
import com.example.tradedemo.dto.TradeResponse;
import com.example.tradedemo.model.Trade;
import com.example.tradedemo.service.TradeService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {

        this.tradeService = tradeService;
    }

    @GetMapping
    public List<TradeResponse> getTrades() {

        return tradeService.getAllTrades();
    }

    @PostMapping
    public TradeResponse createTrade(@Valid @RequestBody TradeRequest request) {

        return tradeService.addTrade(request);
    }

    @GetMapping("/{tradeId}")
    public TradeResponse getTradeById(@PathVariable String tradeId) {
        return tradeService.getTradeById(tradeId);
    }

    @PutMapping("/{tradeId}")
    public TradeResponse updateTrade(
            @PathVariable String tradeId,
            @Valid @RequestBody TradeRequest request) {
        return tradeService.updateTrade(tradeId, request);
    }

    @DeleteMapping("/{tradeId}")
    public void deleteTrade(@PathVariable String tradeId) {
        tradeService.deleteTrade(tradeId);
    }
}
