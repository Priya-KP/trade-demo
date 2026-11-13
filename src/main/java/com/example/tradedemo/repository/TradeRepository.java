package com.example.tradedemo.repository;

import com.example.tradedemo.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, String> {
}