package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.ojects.Dater;


public class Date {
    @Test
    public void showDate(){
        try {
            ParserShippingRequestCola.setDateLoadUnload(Dater.getNow(),Dater.getTomorrow());
        } catch (Exception e) {
            System.err.print("Отстой");
        }
    }
}
