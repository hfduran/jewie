package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.SoldBunch;
import com.example.jewie.backend.bunches.UsableBunch;
import com.example.jewie.backend.finance.exceptions.BunchNotSupportedOnSaleException;
import com.example.jewie.backend.misc.Client;

import java.util.Date;
import java.util.List;

public abstract class SaleBuilder {
    private List<SoldBunch> soldBunches;
    private double value;
    private Date date;
    private Client client;

    public void setData(double value, Date date, Client client) {
        this.value = value;
        this.date = date;
        this.client = client;
    }

    public abstract boolean supportBunch(UsableBunch bunch);

    public void addBunch(UsableBunch bunch, int n) {
        if(!this.supportBunch(bunch)){
            throw new BunchNotSupportedOnSaleException();
        }
        SoldBunch soldBunch = bunch.sell(n);
        this.soldBunches.add(soldBunch);
    }

    protected List<SoldBunch> getSoldBunches() {
        return soldBunches;
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
