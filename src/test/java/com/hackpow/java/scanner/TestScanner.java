package com.hackpow.java.scanner;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestScanner {

    @Test
    public void readFileWithScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/test.txt"));

        assertTrue(scanner.hasNext());
        assertEquals("Hello", scanner.next());
        assertEquals("world", scanner.next());

        scanner.close();
    }

    @Test
    public void convertInputStreamToString() throws FileNotFoundException {
        String expected = "Hello world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/test.txt");
        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("A");
        String result = scanner.next();
        assertEquals(expected, result);

        scanner.close();
    }


    /**
     * Use <code>BufferedReader</code> when we want to read into lines
     * @throws IOException ss
     */
    @Test
    public void readUsingBufferedReader() throws IOException {
        String firstLine = "Hello world";
        String secondLine = "Hi, John";
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test.txt"));

        String result = reader.readLine();
        assertEquals(firstLine, result);

        result = reader.readLine();
        assertEquals(secondLine, result);

        reader.close();
    }

    /**
     * Use <code>Scanner</code> when we want to read into Tokens
     * @throws FileNotFoundException can't find the file
     */
    @Test
    public void readUsingScanner() throws FileNotFoundException {
        String firstLine = "Hello world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/test.txt");

        Scanner scanner = new Scanner(inputStream);
        String result = scanner.nextLine();
        assertEquals(firstLine, result);

        scanner.useDelimiter(", ");
        assertEquals("Hi", scanner.next());
        assertEquals("John", scanner.next());

        scanner.close();
    }

    @Test
    public void readFromConsole() {
        String result = "Hello";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(result.getBytes()));

        Scanner scanner = new Scanner(System.in);
        assertEquals(result, scanner.next());

        System.setIn(stdin);
        scanner.close();
    }

    @Test
    public void scanString() {
        String input = "Hello 1 F 1010 3.3";
        Scanner scanner = new Scanner(input);

        assertEquals("Hello", scanner.next());
        assertEquals(1, scanner.nextInt());
        assertEquals(15, scanner.nextInt(16));
        assertEquals(10, scanner.nextInt(2));
        assertEquals(3.3, scanner.nextDouble(), 1e-8);
    }

    @Test
    public void scanWithPattern() throws FileNotFoundException {
        String expectedValue = "world";
        FileInputStream inputStream = new FileInputStream("src/test/resources/test.txt");
        Scanner scanner = new Scanner(inputStream);

        String result = scanner.findInLine("wo..d");
        assertEquals(expectedValue, result);
    }

    @Test
    public void scanWithMultipleDelimiter() {
        Scanner scanner = new Scanner("John,Adam-Tom");
        scanner.useDelimiter("[,\\-]");
        assertEquals("John", scanner.next());
        assertEquals("Adam", scanner.next());
        assertEquals("Tom", scanner.next());

    }
}
