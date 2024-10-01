package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ConsignedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

public class ConsignedSaleBuilder extends SaleBuilder {
    private Consigned consigned;

    public void setConsigned(Consigned consigned) {
        this.consigned = consigned;
    }

    @Override
    public boolean supportBunch(UsableBunch bunch) {
        return bunch instanceof ConsignedBunch;
    }

    @Override
    public Sale getResult() {
        ConsignedSale sale = new ConsignedSale(this.getDate(), this.getValue(), this.getClient(),
                this.getSoldBunches(), this.consigned);
        this.consigned.addSale(sale);
        return sale;
    }
}
