package com.gcs.account.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

@Slf4j(topic = "Security")
public class Security {

    public static final String ENCODE_KEY_NORMAL = "AVIVSYEKAVIVSYEK";

    private Security() {
        throw new IllegalStateException("Utility class");
    }

    public static String encryptAES(String plainText, String key) {
        try {
            SecureRandom random = new SecureRandom();

            byte[] bytesIV = new byte[16];
            random.nextBytes(bytesIV);

            IvParameterSpec iv = new IvParameterSpec(bytesIV);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printBase64Binary(bytesIV)
                    + ";" + DatatypeConverter.printBase64Binary(encryptedBytes);
        } catch (Exception ex) {
            log.error("AES encryption error", ex);
            return null;
        }
    }

    public static String decryptAES(String secureText, String key) {
        try {
            String[] secureArr = secureText.split(";");
            IvParameterSpec iv = new IvParameterSpec(DatatypeConverter.parseBase64Binary(secureArr[0]));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encryptedBytes = cipher.doFinal(DatatypeConverter.parseBase64Binary(secureArr[1]));
            return new String(encryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            log.error("AES decryption error", ex);
            return null;
        }
    }

    public static void main(String[] args) {
        String text = "12345678";
        log.debug(encryptAES(text, ENCODE_KEY_NORMAL));
    }
}
