package com.example.jewie.backend.bunches;

import java.util.ArrayList;
import java.util.List;

public class BunchCollection<T extends Bunch> {
    protected final List<T> bunches;

    public BunchCollection() {
        this.bunches = new ArrayList<>();
    }

    public BunchCollection(List<T> bunches) {
        this.bunches = bunches;
    }

    public void addBunch(T bunch) {
        this.bunches.add(bunch);
    }

    public int getQuantitySum() {
        return this.bunches.stream().mapToInt(T::getQty).sum();
    }

    public List<T> getBunches() {
        return bunches;
    }
}
