package com.hackpow.java.tryresource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) {
        multipleResource();
    }

    public static void tryResourceMethod() {
        try (Scanner scanner = new Scanner(new File("src/main/resources/test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void normalTryCatchFinally() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void multipleResource() {
        try (
                Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));
                PrintWriter writer = new PrintWriter(new File("src/main/resources/testWrite.txt"))
                ) {
            while (scanner.hasNext()) {
                writer.write(scanner.next());
                writer.write('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
