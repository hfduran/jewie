package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ConsignedSoldBunchCollection;
import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public class Sale {
    private final Date date;
    private final double value;
    private final List<SoldBunch> bunches;
    private final ConsignedSoldBunchCollection consignedBunchesCollection;
    private final Client client;

    public Sale(Date date, double value, Client client, List<SoldBunch> bunches,
                ConsignedSoldBunchCollection consignedBunchesCollection) {
        this.date = date;
        this.value = value;
        this.client = client;
        this.bunches = bunches;
        this.consignedBunchesCollection = consignedBunchesCollection;
    }

    public double getRevenue() {
        return value - consignedBunchesCollection.getValueSum() + consignedBunchesCollection.getProfitSum();
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public List<SoldBunch> getBunches() {
        return bunches;
    }
}
