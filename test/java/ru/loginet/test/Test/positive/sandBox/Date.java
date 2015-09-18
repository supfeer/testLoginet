package ru.loginet.test.Test.positive.sandBox;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by supfe_000 on 18.09.2015.
 */
public class Date {
    @Test
    public void showDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
        System.out.println(dateTimeFormatter.format(localDate));    }
}
