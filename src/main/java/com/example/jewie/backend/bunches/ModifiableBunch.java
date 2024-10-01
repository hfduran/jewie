package com.example.jewie.backend.bunches;

import com.example.jewie.backend.bunches.exceptions.IllegalQuantityOnBunchException;
import com.example.jewie.backend.pieces.Piece;

abstract class ModifiableBunch extends Bunch {

    public ModifiableBunch(Piece piece) {
        super(piece);
    }

    public ModifiableBunch(Piece piece, int qty) {
        super(piece, qty);
    }

    protected void modifyQty(int delta) {
        if(this.qty + delta < 0) {
            throw new IllegalQuantityOnBunchException();
        }
    }
}
