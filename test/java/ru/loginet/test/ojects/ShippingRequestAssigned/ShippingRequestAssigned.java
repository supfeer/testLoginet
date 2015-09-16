package ru.loginet.test.ojects.ShippingRequestAssigned;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

/**
 * Created by supfe_000 on 16.09.2015.
 */
public class ShippingRequestAssigned extends Selenide{
    public static final SelenideElement I_FRAME = $(By.id("ShippingRequestAssigned_IFrame"));

    public static final SelenideElement btnStartAccept = $(By.id("MainContent_ctlContent_btnStartAccept"));
    public static final SelenideElement btnStartCancel = $(By.id("MainContent_ctlContent_btnCancel"));
    public static final SelenideElement btnInsure = $(By.id("MainContent_ctlContent_btnInsure"));
    public static final SelenideElement btnProcess = $(By.id("MainContent_ctlContent_btnProcess"));
    public static final SelenideElement btnFilter = $(By.id("MainContent_ctlContent_btnFilter"));
    public static final SelenideElement mnuReports = $(By.id("MainContent_ctlContent_btnReports"));
    //public static final SelenideElement btnCreateBill = $(By.id("MainContent_ctlContent_btnCreateBill"));

    public static final SelenideElement btnAcceptanceAccept = $(By.id("MainContent_ctlContent_btnAccept"));

    public static void select()
    {
        if(I_FRAME.is(Condition.visible))
        {
            switchTo().frame(I_FRAME);
        }else {
            switchTo().defaultContent();
            switchTo().frame(I_FRAME);
        }
    }
}