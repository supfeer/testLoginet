package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class ShippingRequestDistribute extends Selenide {
    public static final SelenideElement iFrame = $(By.name("ShippingRequestDistribute_IFrame"));
    public static final SelenideElement arrow = $(By.id("MainContent_ctlContent_ctl00_Container")).$(By.tagName("thead")).$(By.className("x-grid3-cell-first")).$(By.className("x-grid3-hd-btn"));

    public static final SelenideElement gplPartnersForDistribution = $(By.id("MainContent_ctlContent_gplPartnersForDistribution-hctx"));
    public static final SelenideElement filter = $(By.linkText("Фильтр"));
    public static final SelenideElement input = $(By.name("ext-comp-1005"));
    public static final SelenideElement btnDistribute = $(By.id("MainContent_ctlContent_btnSendMail"));
    public static final SelenideElement btnCancel = $(By.id("MainContent_ctlContent_btnCancel"));



    public void select()
    {
        if(iFrame.is(Condition.visible))
        {
            switchTo().frame(iFrame);
        }else {
            switchTo().defaultContent();
            switchTo().frame(iFrame);
        }
        $(By.className("x-grid3-scroller")).$(By.className("x-grid3-body")).$(By.className("x-grid3-row-first")).waitUntil(Condition.not(Condition.appear), 30000);
        //arrow.waitUntil(Condition.not(Condition.present),15000);
    }
    public void findPartner(String partner){
        sleep(1000);
        $(By.id("MainContent_ctlContent_ctl00_Container")).$(By.tagName("thead")).$(By.className("x-grid3-cell-first")).hover();//наведет мышку на ячейку Партнер, появится стрелочка
        arrow.click();
        filter.hover();
        input.setValue(partner);
        input.pressEnter();
        $(By.id("ext-gen21-gp-PartnerName-" + partner + "-bd")).$(By.className("x-grid3-cell-first")).click();//найдет выбранного партнера в гриде и нажмет на него

    }
    public void distiributeRequestOnPartner (String partner){
        select();
        findPartner(partner);
        //Выберем первый чекбокс внизу
        $(By.id("MainContent_ctlContent_gplContactPersons")).$(By.className("x-grid3-scroller")).$(By.className("x-grid3-row-first")).$(By.className("x-grid3-row-checker")).setSelected(true);
        btnCancel.click();
        switchTo().defaultContent();
        switchTo().frame(ShippingRequest.I_FRAME);

        sleep(30000);
    }
}
