package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ReceivedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.List;

public class Purchase extends Origin {
    private final double value;
    private List<ReceivedBunch> receivedBunches;
    private List<UsableBunch> bunches;

    public Purchase(List<ReceivedBunch> receivedBunches, List<UsableBunch> bunches, double value) {
        super(receivedBunches, bunches);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
