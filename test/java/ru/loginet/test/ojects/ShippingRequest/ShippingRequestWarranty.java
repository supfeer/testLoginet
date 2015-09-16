package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ShippingRequestWarranty extends Selenide {
    public static final SelenideElement frame = $(By.name("ShippingRequestWarranty_IFrame"));
    public static final SelenideElement btnDistribute = $(By.id("MainContent_ctlContent_Button1"));
    public static SelenideElement btnReDistribute;
    public static final SelenideElement btnConfirmYes = $(By.id("ext-comp-1043"));

    public static void distribute(){
        switchTo().defaultContent();
        switchTo().frame("ShippingRequestWarranty_IFrame");
        btnDistribute.waitUntil(Condition.not(Condition.visible),30000);
        btnDistribute.click();
        btnConfirmYes.click();
        switchTo().defaultContent();
        switchTo().frame(ShippingRequest.frame);
    }
}

