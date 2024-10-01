package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ReceivedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.ArrayList;
import java.util.List;

public class Consigned extends Origin {
    private final List<ConsignedSale> sales = new ArrayList<>();

    public Consigned(List<ReceivedBunch> receivedBunches, List<UsableBunch> bunches) {
        super(receivedBunches, bunches);
    }

    public double applyCommission(double value) {
        double totalValue = this.sales.stream().mapToDouble(ConsignedSale::getValue).sum();
        if (totalValue < 1000) {
            return 0.1 * value;
        } else {
            return 0.2 * value;
        }
    }

    void addSale(ConsignedSale sale) {
        this.sales.add(sale);
    }
}
