package com.example.tradedemo.service;

import com.example.tradedemo.dto.TradeRequest;
import com.example.tradedemo.dto.TradeResponse;
import com.example.tradedemo.exception.TradeNotFoundException;
import com.example.tradedemo.model.Trade;
import com.example.tradedemo.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<TradeResponse> getAllTrades() {
        return tradeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TradeResponse addTrade(TradeRequest request) {

        Trade trade = new Trade(
                request.getTradeId(),
                request.getAccountId(),
                request.getCurrencyPair(),
                request.getSide(),
                request.getAmount(),
                request.getRate(),
                request.getStatus()
        );

        Trade savedTrade = tradeRepository.save(trade);

        return mapToResponse(savedTrade);
    }

    public TradeResponse getTradeById(String tradeId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() ->
                        new TradeNotFoundException("Trade not found: " + tradeId));

        return mapToResponse(trade);
    }

    public TradeResponse updateTrade(String tradeId, TradeRequest request) {

        Trade existingTrade = tradeRepository.findById(tradeId)
                .orElseThrow(() ->
                        new TradeNotFoundException("Trade not found: " + tradeId));

        existingTrade.setAccountId(request.getAccountId());
        existingTrade.setCurrencyPair(request.getCurrencyPair());
        existingTrade.setSide(request.getSide());
        existingTrade.setAmount(request.getAmount());
        existingTrade.setRate(request.getRate());
        existingTrade.setStatus(request.getStatus());

        Trade savedTrade = tradeRepository.save(existingTrade);

        return mapToResponse(savedTrade);
    }

    public void deleteTrade(String tradeId) {
        tradeRepository.deleteById(tradeId);
    }

    private TradeResponse mapToResponse(Trade trade) {
        return new TradeResponse(
                trade.getTradeId(),
                trade.getAccountId(),
                trade.getCurrencyPair(),
                trade.getSide(),
                trade.getAmount(),
                trade.getRate(),
                trade.getStatus()
        );
    }
}