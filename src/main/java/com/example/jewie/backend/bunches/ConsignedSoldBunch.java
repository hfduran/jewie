package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.Consigned;

public class ConsignedSoldBunch extends SoldBunch {
    private final double value;
    private final Consigned consigned;

    public ConsignedSoldBunch(ConsignedBunch originalBunch, int qty, double value) {
        super(originalBunch, qty);
        this.value = value;
        this.consigned = originalBunch.getConsigned();
    }

    public double getValue() {
        return value;
    }

    public double getProfit() {
        return this.consigned.applyCommission(value);
    }
}
