package com.hackpow.java.sync;

import lombok.Data;
import lombok.Synchronized;

@Data
public class SyncMethod {
    private int sum = 0;

    @Synchronized
    public void calculate() {
        setSum(getSum() + 1);
    }
}
