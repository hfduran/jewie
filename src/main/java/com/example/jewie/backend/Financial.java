package com.example.jewie.backend;

import com.example.jewie.backend.finance.Consigned;
import com.example.jewie.backend.finance.Purchase;
import com.example.jewie.backend.finance.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Financial {
    private static Financial singletonInstance;
    public static Financial getInstance() {
        if (singletonInstance == null) singletonInstance = new Financial();
        return singletonInstance;
    }

    private final List<Sale> sales = new ArrayList<>();
    private final List<Purchase> purchases = new ArrayList<>();
    private final List<Consigned> consigneds = new ArrayList<>();

    public List<Sale> getSales() {
        return sales;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public List<Consigned> getConsigneds() {
        return consigneds;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public void addConsigned(Consigned consigned) {
        this.consigneds.add(consigned);
    }

    public double getAllTimeProfit() {
        double salesRevenue = this.sales.stream().mapToDouble(Sale::getRevenue).sum();
        double purchasesValue = this.purchases.stream().mapToDouble(Purchase::getValue).sum();
        return salesRevenue - purchasesValue;
    }

    /*
    * TODO:
    *  remove sales, purchases and consigned. Need to rollback all bunches created in process
    * */
}
