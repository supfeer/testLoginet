package ru.loginet.test.ojects.tools;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by supfe_000 on 24.09.2015.
 */
public class Js {
    public static String getText(String id) {
        return $(By.id(id)).val();
        //return executeJavaScript("return document.getElementById('" + id + "').value");
    }

    public static void compare(String id, String value) {
        if (!$(By.id(id)).val().equals(value))
            $(By.id(id + " should have text " + value)).click();
    }

}
