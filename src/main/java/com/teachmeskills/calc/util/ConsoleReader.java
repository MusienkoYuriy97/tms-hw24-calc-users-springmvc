package com.teachmeskills.calc.util;

public class ConsoleReader {
    public static void read(Object message) {
        System.out.println(message);
    }

    public static void read(Object... message) {
        for (Object s : message) {
            System.out.println(s);
        }
    }
}
