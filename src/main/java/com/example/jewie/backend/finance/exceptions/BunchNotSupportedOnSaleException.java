package com.example.jewie.backend.finance.exceptions;

public class BunchNotSupportedOnSaleException extends RuntimeException {
    public BunchNotSupportedOnSaleException() {
        super("Bunch is not supported on Sale");
    }
}
