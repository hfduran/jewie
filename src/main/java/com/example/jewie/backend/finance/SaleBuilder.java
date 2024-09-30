package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ConsignedSoldBunchCollection;
import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.bunches.UsableBunch;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public abstract class SaleBuilder {
    private final ConsignedSoldBunchCollection consignedSoldBunchCollection =
            new ConsignedSoldBunchCollection();
    private List<SoldBunch> soldBunches;
    private double value;
    private Date date;
    private Client client;

    public void setMetadata(double value, Date date, Client client) {
        this.value = value;
        this.date = date;
        this.client = client;
    }

    public void addBunch(UsableBunch bunch, int n) {
        SoldBunch soldBunch = bunch.sell(n);
        this.soldBunches.add(soldBunch);
    }

    protected List<SoldBunch> getSoldBunches() {
        return soldBunches;
    }

    protected ConsignedSoldBunchCollection getConsignedSoldBunchCollection() {
        return consignedSoldBunchCollection;
    }

    protected double getValue() {
        return value;
    }

    protected Date getDate() {
        return date;
    }

    protected Client getClient() {
        return client;
    }

    public abstract Sale getResult();
}
