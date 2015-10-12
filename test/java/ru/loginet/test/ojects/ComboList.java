package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


/**
 * Created by supfe_000 on 01.10.2015.
 */
public class ComboList {
    public static void setType(SelenideElement list, String value) {
        list.parent().$$(By.className("x-combo-list-item"))
                .findBy(Condition.text(value)).click();
    }

    public static void setFirst(SelenideElement list) {
        list.parent().$(By.className("x-combo-list-item"))
                .click();
    }
}
