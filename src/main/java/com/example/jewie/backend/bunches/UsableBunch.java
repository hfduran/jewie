package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

public abstract class UsableBunch extends ModifiableBunch {
    private final SuspendedBunch suspendedBunch = new SuspendedBunch();

    public UsableBunch(Piece piece, int qty) {
        this.piece = piece;
        this.qty = qty;
    }

    public int getSuspendedQty() {
        return this.suspendedBunch.qty;
    }

    public void suspend(int n) {
        this.modifyQty(-n);
        this.suspendedBunch.suspend(n);
    }

    public void restore(int n) {
        this.modifyQty(n);
        this.suspendedBunch.restore(n);
    }

    public void suspendAll() {
        int n = this.qty;
        this.modifyQty(-n);
        this.suspendedBunch.suspend(n);
    }

    public void restoreAll() {
        int n = this.suspendedBunch.restoreAll();
        this.modifyQty(n);
    }
}
