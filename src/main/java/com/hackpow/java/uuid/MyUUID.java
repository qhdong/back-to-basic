package com.hackpow.java.uuid;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MyUUID {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        getUUIDv3();
        getUUIDv4();
        System.out.println(getUniqueKey());
    }

    private static void getUUIDv3() {
        String namespace = "www.hackpow.com";
        String name = "dongqihong@vip.qq.com";
        String source = namespace + name;
        byte[] bytes = source.getBytes(Charset.forName("UTF-8"));
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        System.out.println(uuid);
    }

    private static void getUUIDv4() {
        System.out.println(UUID.randomUUID());
    }

    private static String getUniqueKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
        return new String(salt.digest());
    }
}
