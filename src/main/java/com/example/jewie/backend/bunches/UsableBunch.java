package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.OwnedSaleBuilder;
import com.example.jewie.backend.finance.SaleBuilder;
import com.example.jewie.backend.pieces.Piece;

public abstract class UsableBunch extends ModifiableBunch {
    private final SuspendedBunch suspendedBunch;

    public UsableBunch(Piece piece) {
        super(piece);
        this.suspendedBunch = new SuspendedBunch(this.piece);
    }

    public UsableBunch(Piece piece, int qty) {
        super(piece, qty);
        this.suspendedBunch = new SuspendedBunch(this.piece);
        this.piece.addBunch(this);
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

    public abstract SaleBuilder getSaleBuilder();

    public SoldBunch sell(int n) {
        this.modifyQty(-n);
        return new SoldBunch(this, n);
    }
}
