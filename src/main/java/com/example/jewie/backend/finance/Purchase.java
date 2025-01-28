package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.OwnedBunch;
import com.example.jewie.backend.bunches.ReceivedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.List;

public class Purchase extends Origin {
    private final double value;

    public Purchase(List<ReceivedBunch> receivedBunches, double value) {
        super(receivedBunches,
                receivedBunches.stream()
                        .map(x -> (UsableBunch) new OwnedBunch(x.getPiece(), x.getQty()))
                        .toList());
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
