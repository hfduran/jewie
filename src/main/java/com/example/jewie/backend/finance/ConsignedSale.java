package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public class ConsignedSale extends Sale {
    private final Consigned consigned;

    public ConsignedSale(
            Date date, double value, Client client, List<SoldBunch> bunches, Consigned consigned
    ) {
        super(date, value, client, bunches);
        this.consigned = consigned;
    }

    @Override
    public double getRevenue() {
        return this.consigned.applyCommission(this.getValue());
    }
}
