package nl.groep4b;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static byte[] hashToByteArray(String password) {
        try {
            // Hash password
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());

            // Return hashed password
            return messageDigest.digest();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String hashToString(String password) {
        try {
            // Hash password
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            // Build string from byte[]
            StringBuilder sb = new StringBuilder();
            for (byte b: resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            // Return hashed password
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static byte[] stringToByteArray(String base64String) {
        return Base64.decodeBase64(base64String);
    }

    public static String byteArrayToString(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }
}