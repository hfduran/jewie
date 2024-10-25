package com.example.jewie.backend.pieces;

import com.example.jewie.backend.bunches.BunchCollection;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String code;
    private String name;
    private Double catalogPrice;
    private PieceType type;
    private final BunchCollection<UsableBunch> bunchCollection = new BunchCollection<>();

    public Piece(String code, String name, Double catalogPrice, PieceType type) {
        this.code = code;
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

    public String getCode() {
        return code;
    }
}
