package com.example.jewie.backend.pieces;

public class Piece {
    private String name;
    private Double catalogPrice;
    private PieceType type;

    public Piece(String name, Double catalogPrice, PieceType type) {
        this.name = name;
        this.catalogPrice = catalogPrice;
        this.type = type;
    }
}
