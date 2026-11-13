package com.example.tradedemo.exception;

public class TradeNotFoundException extends RuntimeException {

    public TradeNotFoundException(String message) {
        super(message);
    }
}