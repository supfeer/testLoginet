package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.tools.Dater;


public class Date {
    @Test
    public void showDate(){
        System.out.println(Dater.getUnique());
    }
}
