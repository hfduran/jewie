package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.UsableBunch;

import java.util.ArrayList;
import java.util.List;

public class Consigned implements Origin {
    private final List<UsableBunch> bunches;
    private final List<ConsignedSale> sales = new ArrayList<>();

    public Consigned(List<UsableBunch> bunches) {
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

    @Override
    public SaleBuilder getSaleBuilder() {
        ConsignedSaleBuilder saleBuilder = new ConsignedSaleBuilder();
        saleBuilder.setConsigned(this);
        return saleBuilder;
    }

    void addSale(ConsignedSale sale) {
        this.sales.add(sale);
    }
}
