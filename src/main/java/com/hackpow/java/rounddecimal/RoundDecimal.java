package com.hackpow.java.rounddecimal;

import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundDecimal {
    public static void main(String[] args) {
//        testDecimalFormat();
//        System.out.println(round(Math.PI, 1));
        System.out.println(Precision.round(Math.PI, 4));
    }

    private static void testDecimalFormat() {
        DecimalFormat df = new DecimalFormat("###.###");
        System.out.println(df.format(2.4983994));
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
