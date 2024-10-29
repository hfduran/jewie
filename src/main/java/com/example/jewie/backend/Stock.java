package com.example.jewie.backend;

import com.example.jewie.backend.exceptions.PieceCodeAlreadyExistsException;
import com.example.jewie.backend.pieces.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private static Stock singletonInstance;
    public static Stock getInstance() {
        if (singletonInstance == null) singletonInstance = new Stock();
        return singletonInstance;
    }

    private final Map<String, Piece> pieces = new HashMap<>();

    public void addPiece(Piece piece) {
        String code = piece.getCode();
        if (this.pieces.containsKey(code)) {
            throw new PieceCodeAlreadyExistsException(code);
        }
        this.pieces.put(code, piece);
    }

    public List<Piece> getCatalog() {
        return pieces.values().stream().filter(p -> p.getQty() > 0).toList();
    }

    public List<Piece> getPieces() {
        return pieces.values().stream().toList();
    }
}
