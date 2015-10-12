package ru.loginet.test.ojects.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by supfe_000 on 18.09.2015.
 */
public class Dater {

    public static String getToday() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        return dateTimeFormatter.format(localDate);
    }

    public static String getTomorrow() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        return dateTimeFormatter.format(localDate);
    }

    public static String get5daysAgo() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(5);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        return dateTimeFormatter.format(localDate);
    }

    public static String getNowMinus(int days) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        return dateTimeFormatter.format(localDate);
    }

    public static String getNowPlus(int days) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        return dateTimeFormatter.format(localDate);
    }

    public static String getUnique() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMeeHHmm");
        return dateTimeFormatter.format(localDate);
    }
}
