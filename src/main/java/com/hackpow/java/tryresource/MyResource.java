package com.hackpow.java.tryresource;

public class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Closed MyResource");
    }

    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            System.out.println(resource.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
