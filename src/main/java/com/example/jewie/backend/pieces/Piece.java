package com.example.jewie.backend.pieces;

import com.example.jewie.backend.bunches.BunchCollection;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String name;
    private Double catalogPrice;
    private PieceType type;
    private BunchCollection<UsableBunch> bunchCollection = new BunchCollection<>();

    public Piece(String name, Double catalogPrice, PieceType type) {
        this.name = name;
        this.catalogPrice = catalogPrice;
        this.type = type;
    }

    public List<UsableBunch> getBunches() {
        return this.bunchCollection.getBunches();
    }

    public int getQty() {
        return this.bunchCollection.getQuantitySum();
    }
}
