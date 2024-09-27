package com.example.jewie.backend.bunches;

import com.example.jewie.backend.pieces.Piece;

public class SoldBunch extends Bunch {

    protected Bunch originalBunch;

    public SoldBunch(Bunch originalBunch, int qty) {
        Piece piece = originalBunch.piece;
        this.originalBunch = originalBunch;
        this.qty = qty;
        this.piece = piece;
    }
}
