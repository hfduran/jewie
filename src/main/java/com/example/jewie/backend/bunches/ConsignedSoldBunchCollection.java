package com.example.jewie.backend.bunches;

import java.util.ArrayList;
import java.util.List;

public class ConsignedSoldBunchCollection {
    private final List<ConsignedSoldBunch> bunches;

    public ConsignedSoldBunchCollection() {
        this.bunches = new ArrayList<>();
    }

    public ConsignedSoldBunchCollection(List<ConsignedSoldBunch> bunches) {
        this.bunches = bunches;
    }

    public void add(ConsignedSoldBunch bunch) {
        this.bunches.add(bunch);
    }

    public double getValueSum() {
        return this.bunches.stream().mapToDouble(ConsignedSoldBunch::getValue).sum();
    }

    public double getProfitSum() {
        return this.bunches.stream().mapToDouble(ConsignedSoldBunch::getProfit).sum();
    }
}
