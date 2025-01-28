package com.example.jewie.backend.bunches;

import com.example.jewie.backend.finance.Origin;
import com.example.jewie.backend.pieces.Piece;

public class ReceivedBunch extends Bunch {
    /*
    Utilizado para guardar o estado de uma entrada. Ele é imutável. É só pra não
    perder track de quando faz uma purchase ou consigned, precisa saber exatamente
    quantos vieram naquele momento.
     */
    private Origin origin;

    public ReceivedBunch(Piece piece, int qty) {
        super(piece, qty);
    }

    public void setOrigin(Origin origin) {
        if(this.origin != null) {
            throw new RuntimeException("ReceivedBunch already assigned to an origin");
        } else {
            this.origin = origin;
        }
    }
}
