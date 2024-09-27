package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.Consigned;
import com.example.jewie.backend.pieces.Piece;

public class ConsignedBunch extends UsableBunch {
    private final Consigned consigned;

    public ConsignedBunch(Piece piece, int qty, Consigned consigned) {
        super(piece, qty);
        this.consigned = consigned;
    }

    public ConsignedSoldBunch sell(int n, double value) {
        ConsignedSoldBunch consignedSoldBunch = new ConsignedSoldBunch(this, n, value);
        this.consigned.registerSoldBunch(consignedSoldBunch);
        return consignedSoldBunch;
    }

    Consigned getConsigned() {
        return consigned;
    }
}
