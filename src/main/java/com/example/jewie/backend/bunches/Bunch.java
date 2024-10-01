package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

public abstract class Bunch {
    protected int qty;
    protected Piece piece;

    public Bunch(Piece piece) {
        this.qty = 0;
        this.piece = piece;
    }

    public Bunch(Piece piece, int qty) {
        this.qty = qty;
        this.piece = piece;
    }

    public int getQty() {
        return qty;
    }
}