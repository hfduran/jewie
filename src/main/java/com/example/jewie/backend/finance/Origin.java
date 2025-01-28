package com.example.jewie.backend.finance;

import com.example.jewie.backend.bunches.ReceivedBunch;
import com.example.jewie.backend.bunches.UsableBunch;

import java.util.List;

public abstract class Origin {
    protected final List<ReceivedBunch> receivedBunches;
    protected final List<UsableBunch> bunches;

    public Origin(List<ReceivedBunch> receivedBunches, List<UsableBunch> bunches) {
        this.receivedBunches = receivedBunches;
        for (ReceivedBunch receivedBunch : this.receivedBunches) {
            receivedBunch.setOrigin(this);
        }
        this.bunches = bunches;
    }
}
