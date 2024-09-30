package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public abstract class Sale {
    private final Date date;
    private final double value;
    private final List<SoldBunch> bunches;
    private final Client client;

    public Sale(Date date, double value, Client client, List<SoldBunch> bunches) {
        this.date = date;
        this.value = value;
        this.client = client;
        this.bunches = bunches;
    }

    public abstract double getRevenue();

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
