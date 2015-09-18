package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.Dater;


public class Date {
    @Test
    public void showDate(){
        System.out.println(Dater.getNow());
        System.out.println(Dater.getTomorrow());
        System.out.println(Dater.get5daysAgo());
        System.out.println(Dater.getNowPlus(5));
        System.out.println(Dater.getNowMinus(5));
    }
}
