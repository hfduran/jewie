package com.example.jewie.backend;

import com.example.jewie.backend.bunches.UsableBunch;
import com.example.jewie.backend.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final List<Piece> pieces = new ArrayList<>();

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public List<Piece> getCatalog() {
        return pieces.stream().filter(p -> p.getQty() > 0).toList();
    }
}
