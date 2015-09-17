package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class ShippingRequestDistribute extends Selenide {
    public static final SelenideElement iFrame = $(By.name("ShippingRequestDistribute_IFrame"));
    public static final SelenideElement arrow = $(By.id("MainContent_ctlContent_ctl00_Container")).$(By.tagName("thead")).$(By.className("x-grid3-cell-first")).$(By.className("x-grid3-hd-btn"));

    public static final SelenideElement gplPartnersForDistribution = $(By.id("MainContent_ctlContent_gplPartnersForDistribution-hctx"));
    public static final SelenideElement filter = $(By.linkText("Фильтр"));
    public static final SelenideElement input = $(By.name("ext-comp-1005"));

}
