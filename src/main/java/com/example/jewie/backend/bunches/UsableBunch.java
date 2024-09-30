package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.Origin;
import com.example.jewie.backend.finance.SaleBuilder;
import com.example.jewie.backend.pieces.Piece;

public class UsableBunch extends ModifiableBunch {
    private final SuspendedBunch suspendedBunch = new SuspendedBunch();
    private final Origin origin;

    public UsableBunch(Piece piece, int qty, Origin origin) {
        this.piece = piece;
        this.qty = qty;
        this.origin = origin;
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

    public SaleBuilder getSaleBuilder() {
        return this.origin.getSaleBuilder();
    }

    public SoldBunch sell(int n) {
        this.modifyQty(-n);
        return new SoldBunch(this, n);
    }
}
