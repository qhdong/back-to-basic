package com.hackpow.java.enumtest;

import java.util.Arrays;
import java.util.EnumSet;

public enum DaysOfWeekEnum {
    MONDAY("working"),
    TUESDAY("working"),
    WEDTHDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off"),
    SUNDAY("off");

    private String typeOfDay;

    DaysOfWeekEnum(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    public static void main(String[] args) {
        EnumSet.allOf(DaysOfWeekEnum.class).forEach(System.out::println);

        for (DaysOfWeekEnum day : DaysOfWeekEnum.values()) {
            System.out.println(day);
        }
    }
}
