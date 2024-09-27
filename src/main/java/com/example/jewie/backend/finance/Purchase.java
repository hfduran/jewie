package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.OwnedBunch;

import java.util.List;

public class Purchase {
    private List<OwnedBunch> bunches;
    private double value;

    public Purchase(List<OwnedBunch> bunches, double value) {
        this.bunches = bunches;
        this.value = value;
    }
}
