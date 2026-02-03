package org.example.fitnessstudioverwaltung.Helper;

import org.example.fitnessstudioverwaltung.Domain.*;
import java.time.LocalDate;
import java.time.Period;

public class Alter {

    // überprüft alter
    public static boolean isAdult(String gebDatum) {
        String[] arr = gebDatum.split("-");

        int jahr = Integer.parseInt(arr[0]);
        int monat = Integer.parseInt(arr[1]);
        int tag = Integer.parseInt(arr[2]);

        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(jahr, monat, tag);

        Period period = Period.between(birthday, now);

        if (period.getYears() >= 18) {
            return true;
        }
        return false;
    }

    // Methode die das aktuelle Alter zurück gibt und die Tage bis
    // die Person 18 wird!

    /// Methode die überprüft ob es den Username
    // in der Datenbank schon gibt
}
