package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.UsableBunch;

import java.util.List;

public class Purchase implements Origin {
    private List<UsableBunch> bunches;
    private final double value;

    public Purchase(List<UsableBunch> bunches, double value) {
        this.bunches = bunches;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public SaleBuilder getSaleBuilder() {
        return new OwnedSaleBuilder();
    }
}
