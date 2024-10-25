package com.example.jewie.backend.exceptions;

public class PieceCodeAlreadyExistsException extends RuntimeException {
    public PieceCodeAlreadyExistsException(String code) {
        super(String.format("A piece with the code '%s' already exists.", code));
    }
}
