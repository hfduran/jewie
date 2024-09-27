package com.example.jewie.backend.bunches;

class SuspendedBunch extends ModifiableBunch {
    public SuspendedBunch() {
        this.qty = 0;
    }

    public void suspend(int n) {
        this.modifyQty(n);
    }

    public void restore(int n) {
        this.modifyQty(-n);
    }

    public int restoreAll() {
        int n = this.qty;
        this.modifyQty(-n);
        return n;
    }
}
