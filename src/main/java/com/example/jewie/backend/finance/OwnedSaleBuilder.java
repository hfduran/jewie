package com.example.jewie.backend.finance;

public class OwnedSaleBuilder extends SaleBuilder {
    @Override
    public Sale getResult() {
        return new OwnedSale(this.getDate(), this.getValue(), this.getClient(),
                this.getSoldBunches());
    }
}
