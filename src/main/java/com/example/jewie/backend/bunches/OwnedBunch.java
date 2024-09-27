package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

public class OwnedBunch extends UsableBunch {
    public OwnedBunch(Piece piece, int qty) {
        super(piece, qty);
    }

    public SoldBunch sell(int n) {
        this.modifyQty(-n);
        return new SoldBunch(this, n);
    }
}
