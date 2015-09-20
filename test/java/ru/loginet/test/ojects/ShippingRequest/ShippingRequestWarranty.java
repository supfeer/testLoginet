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
        $(By.className("x-mask-loading")).waitWhile(Condition.present, 45000);
        switchTo().frame("ShippingRequestWarranty_IFrame");
        btnDistribute.waitUntil(Condition.not(Condition.visible), 50000);
        btnDistribute.click();
        btnConfirmYes.click();
        switchTo().defaultContent();
        $(By.id("BaseMainContent_MainTabPanel__ShippingRequestWarranty")).waitWhile(Condition.present, 30000);
        //ShippingRequest.I_FRAME.waitUntil(Condition.not(Condition.visible),30000);
        //$(By.id("MainContent_ctlContent_frmRequestsList")).waitUntil(Condition.not(Condition.visible), 30000);
    }
}

