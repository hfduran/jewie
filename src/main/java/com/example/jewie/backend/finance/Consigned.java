package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ConsignedBunch;
import com.example.jewie.backend.bunches.ConsignedSoldBunch;

import java.util.ArrayList;
import java.util.List;

public class Consigned {
    private final List<ConsignedBunch> bunches;
    private final List<ConsignedSoldBunch> soldBunches = new ArrayList<>();

    public Consigned(List<ConsignedBunch> bunches) {
        this.bunches = bunches;
    }

    public void registerSoldBunch(ConsignedSoldBunch soldBunch) {
        this.soldBunches.add(soldBunch);
    }

    public double applyCommission(double value) {
        double totalValue = soldBunches.stream().mapToDouble(ConsignedSoldBunch::getValue).sum();
        if (totalValue < 1000) {
            return 0.1 * value;
        } else {
            return 0.2 * value;
        }
    }
}
