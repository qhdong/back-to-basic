package com.hackpow.java.sync;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SyncMethodTest {

    @Test
    public void withoutSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SyncMethod summation = new SyncMethod();

        int high = 1000;
        IntStream.range(0, high)
                .forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(1 * high, TimeUnit.MILLISECONDS);

        assertEquals(high, summation.getSum());
    }
}