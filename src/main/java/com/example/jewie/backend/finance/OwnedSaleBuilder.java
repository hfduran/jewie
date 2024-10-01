package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.OwnedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

public class OwnedSaleBuilder extends SaleBuilder {
    @Override
    public boolean supportBunch(UsableBunch bunch) {
        return bunch instanceof OwnedBunch;
    }

    @Override
    public Sale getResult() {
        return new OwnedSale(this.getDate(), this.getValue(), this.getClient(),
                this.getSoldBunches());
    }
}
