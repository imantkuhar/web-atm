package util;


import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Created by Imant on 29.05.17.
 */
public class EncryptionService {

    public static String encodeCardNumber(String cardNumber) {
        byte[] bytesEncoded = Base64.encodeBase64(cardNumber.getBytes());
        return new String(bytesEncoded);
    }

    public static String decodeCardNumber(byte[] bytesEncoded) {
        byte[] bytesDecoded = Base64.decodeBase64(bytesEncoded);
        return new String(bytesDecoded);
    }
}
