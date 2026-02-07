package org.example.fitnessstudioverwaltung.Helper;

public class PwdCheck {

    public static boolean pwdValidLength(String password) {
        // überprüft die Länge des Passwords
        return password.length() >= 8;
    }


    public static boolean pwdHasUpperCase(String password) {
        char[] charArray = password.toCharArray();

        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean pwdHasNumber (String password) {
        char[] charArray = password.toCharArray();

        for (char c : charArray) {
            // überprüfung ob eine Zahl dabei ist
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

}
