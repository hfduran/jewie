package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.*;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public class SaleBuilder {
    private List<SoldBunch> soldBunches;
    private final ConsignedSoldBunchCollection consignedSoldBunchCollection = new ConsignedSoldBunchCollection();
    private double value;
    private Date date;
    private Client client;

    public void setMetadata(double value, Date date, Client client) {
        this.value = value;
        this.date = date;
        this.client = client;
    }

    public void addBunch(OwnedBunch bunch, int n) {
        SoldBunch soldBunch = bunch.sell(n);
        this.soldBunches.add(soldBunch);
    }

    public void addBunch(ConsignedBunch bunch, int n, double value) {
        ConsignedSoldBunch soldBunch = bunch.sell(n, value);
        this.soldBunches.add(soldBunch);
        this.consignedSoldBunchCollection.add(soldBunch);
    }

    public Sale getResult() {
        return new Sale(date, value, client, soldBunches, consignedSoldBunchCollection);
    }
}
