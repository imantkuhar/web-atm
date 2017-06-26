package com.atm.domain.util;


import org.apache.commons.codec.binary.Base64;

/**
 * Created by Imant on 29.05.17.
 */
public class EncryptionUtil {

    public static String encode(String cardNumber) {
        byte[] bytesEncoded = Base64.encodeBase64(cardNumber.getBytes());
        return new String(bytesEncoded);
    }

    public static String decode(byte[] bytesEncoded) {
        byte[] bytesDecoded = Base64.decodeBase64(bytesEncoded);
        return new String(bytesDecoded);
    }
}
