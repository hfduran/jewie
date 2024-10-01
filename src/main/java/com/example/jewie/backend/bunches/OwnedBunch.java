package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.OwnedSaleBuilder;
import com.example.jewie.backend.finance.SaleBuilder;
import com.example.jewie.backend.pieces.Piece;

public class OwnedBunch extends UsableBunch {

    public OwnedBunch(Piece piece, int qty) {
        super(piece, qty);
    }

    @Override
    public SaleBuilder getSaleBuilder() {
        return new OwnedSaleBuilder();
    }
}
