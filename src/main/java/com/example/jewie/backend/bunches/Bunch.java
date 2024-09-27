package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

public abstract class Bunch {
    protected int qty;
    protected Piece piece;

    public int getQty() {
        return qty;
    }
}