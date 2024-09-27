package com.example.jewie.backend.bunches;

import com.example.jewie.backend.bunches.exceptions.IllegalQuantityOnBunchException;

abstract class ModifiableBunch extends Bunch {
    protected void modifyQty(int delta) {
        if(this.qty + delta < 0) {
            throw new IllegalQuantityOnBunchException();
        }
    }
}
