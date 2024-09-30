package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ConsignedBunch;

import java.util.ArrayList;
import java.util.List;

public class Consigned {
    private final List<ConsignedBunch> bunches;
    private final List<ConsignedSale> sales = new ArrayList<>();

    public Consigned(List<ConsignedBunch> bunches) {
        this.bunches = bunches;
    }

    public double applyCommission(double value) {
        double totalValue = this.sales.stream().mapToDouble(ConsignedSale::getValue).sum();
        if (totalValue < 1000) {
            return 0.1 * value;
        } else {
            return 0.2 * value;
        }
    }
}
