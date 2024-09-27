package com.example.jewie.backend.bunches;

import java.util.ArrayList;
import java.util.List;

public class ConsignedSoldBunchCollection extends BunchCollection<ConsignedSoldBunch> {

    public double getValueSum() {
        return this.bunches.stream().mapToDouble(ConsignedSoldBunch::getValue).sum();
    }

    public double getProfitSum() {
        return this.bunches.stream().mapToDouble(ConsignedSoldBunch::getProfit).sum();
    }
}
