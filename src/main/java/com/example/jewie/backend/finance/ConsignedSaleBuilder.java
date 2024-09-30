package com.example.jewie.backend.finance;

public class ConsignedSaleBuilder extends SaleBuilder {
    private Consigned consigned;

    public void setConsigned(Consigned consigned) {
        this.consigned = consigned;
    }

    @Override
    public Sale getResult() {
        ConsignedSale sale = new ConsignedSale(this.getDate(), this.getValue(), this.getClient(),
                this.getSoldBunches(), this.consigned);
        this.consigned.addSale(sale);
        return sale;
    }
}
