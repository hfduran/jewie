package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.Consigned;
import com.example.jewie.backend.finance.ConsignedSaleBuilder;
import com.example.jewie.backend.finance.SaleBuilder;
import com.example.jewie.backend.pieces.Piece;

public class ConsignedBunch extends UsableBunch {
    private final Consigned consigned;

    public ConsignedBunch(Piece piece, int qty, Consigned consigned) {
        super(piece, qty);
        this.consigned = consigned;
    }
    
    @Override
    public SaleBuilder getSaleBuilder() {
        ConsignedSaleBuilder saleBuilder = new ConsignedSaleBuilder();
        saleBuilder.setConsigned(this.consigned);
        return saleBuilder;
    }
}
