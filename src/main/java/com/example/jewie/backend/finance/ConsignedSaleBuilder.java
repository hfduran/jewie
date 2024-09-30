package com.example.jewie.backend.finance;

public class ConsignedSaleBuilder extends SaleBuilder {
    private Consigned consigned;

    public void setConsigned(Consigned consigned) {
        this.consigned = consigned;
    }

    @Override
    public Sale getResult() {
        return new ConsignedSale(this.getDate(), this.getValue(), this.getClient(), this.getSoldBunches(), this.consigned);
    }
}
