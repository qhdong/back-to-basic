package com.hackpow.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

    public static <T> Stream<T> insertInStream(Stream<T> stream, T element, int index) {
        List<T> result = stream.collect(Collectors.toList());
        result.add(index, element);
        return result.stream();
    }
}
