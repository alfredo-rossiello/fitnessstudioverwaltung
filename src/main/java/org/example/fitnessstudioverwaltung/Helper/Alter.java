package org.example.fitnessstudioverwaltung.Helper;

import org.example.fitnessstudioverwaltung.Domain.*;
import java.time.LocalDate;
import java.time.Period;

public class Alter {

    // überprüft alter
    public static boolean isAdult(int jahr, int monat, int tag) {
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
