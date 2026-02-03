package org.example.fitnessstudioverwaltung.Helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PwdHash {
    public static String hashPassword(String password) {
        try {
            //MessageDigest-Instanz zum SHA 256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //Hashen in Byte Array, weil sonst nur ein Byte
            byte[] hashedPassword = md.digest(password.getBytes());

            //Convert in einen String für die Datenbank
            return Base64.getEncoder().encodeToString(hashedPassword);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Fehler beim Hashen", e);
        }
    }
}
