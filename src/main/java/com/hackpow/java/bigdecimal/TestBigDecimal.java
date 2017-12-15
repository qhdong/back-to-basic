package com.hackpow.java.bigdecimal;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal(String.valueOf(13.22d));
        BigDecimal e = new BigDecimal(String.valueOf(4.88d));
        BigDecimal f = new BigDecimal(String.valueOf(21.45d));

        BigDecimal def = d.add(e).add(f);
        BigDecimal dfe = d.add(f).add(e);

        System.out.println("d + e + f = " + def);
        System.out.println("d + f + e = " + dfe);
    }
}
