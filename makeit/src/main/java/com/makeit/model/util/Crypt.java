package com.makeit.model.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
public class Crypt {

    /**
     * Función de encriptación en MD5
     *
     * @param original
     * @return Texto encriptado.
     */
    public static String encripta(String original) {

        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(original.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * <b>No furula guay</b>Función para encriptar en SHA-256
     *
     * @param original Texto a encriptar
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String old_encripta(String original) {

        String pwd = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(salteameBaby());

            byte[] bytes = md.digest(original.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pwd = sb.toString();
        } catch (Exception e) {
            System.out.println("Error al encriptar:" + e.getMessage());
        }

        return pwd;
    }

    /**
     *
     * @return
     */
    private static byte[] salteameBaby() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
