package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

class SuspendedBunch extends ModifiableBunch {

    public SuspendedBunch(Piece piece) {
        super(piece);
    }

    public void suspend(int n) {
        this.modifyQty(n);
    }

    public void restore(int n) {
        this.modifyQty(-n);
    }

    public int restoreAll() {
        int n = this.qty;
        this.modifyQty(-n);
        return n;
    }
}
