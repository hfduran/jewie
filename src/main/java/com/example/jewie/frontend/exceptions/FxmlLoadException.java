package com.example.jewie.frontend.exceptions;

public class FxmlLoadException extends RuntimeException {
    public FxmlLoadException(String path) {
        super("Error loading FXML file: " + path);
    }
}
