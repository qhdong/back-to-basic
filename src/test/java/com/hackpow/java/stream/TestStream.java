package com.hackpow.java.stream;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.stream.Stream;

public class TestStream {

    @Test
    public void concatStream() {
        Stream<Integer> anStream = Stream.of(1, 2, 3);
        Stream<Integer> newStream = Stream.concat(anStream, Stream.of(99));
        assertEquals(newStream.findFirst().get(), (Integer) 1);
    }

    @Test
    public void testInsertStream() {
        Stream<Integer> anStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> result = MyStream.insertInStream(anStream, 10, 0);
        assertEquals(result.findFirst().get(), (Integer) 10);

    }
}
