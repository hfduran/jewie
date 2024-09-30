package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public class OwnedSale extends Sale {

    public OwnedSale(Date date, double value, Client client, List<SoldBunch> bunches) {
        super(date, value, client, bunches);
    }

    @Override
    public double getRevenue() {
        return this.getValue();
    }
}
