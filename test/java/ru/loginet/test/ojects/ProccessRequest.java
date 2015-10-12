package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

/**
 * Created by supfe_000 on 25.09.2015.
 */
public class ProccessRequest extends Selenide {
    protected static final SelenideElement I_FRAME = $(By.name("ShippingRequestProcess_IFrame"));
    //btns
    public final SelenideElement btnStartProcess = $(By.id("MainContent_ctlContent_btnStartProcess"));
    public final SelenideElement btnFinishProcess = $(By.id("MainContent_ctlContent_btnFinishProcess"));
    public final SelenideElement btnCorrectPrice = $(By.id("MainContent_ctlContent_btnCorrectPrice"));
    public final SelenideElement btnCargoReturn = $(By.id("MainContent_ctlContent_btnCargoReturn"));
    public final SelenideElement btnCargoMovies = $(By.id("MainContent_ctlContent_btnCargoMovies"));
    public final SelenideElement btnAcceptChanges = $(By.id("MainContent_ctlContent_btnAcceptChanges"));
    //panel
    public final SelenideElement pnlRequestFiles = $$(By.className("x-tab-strip-text ")).findBy(Condition.text("Документы по исполнению заявки"));
    public final SelenideElement btnUpload = $(By.id("MainContent_ctlContent_uplFiles_btnChoose"));
    //combo list
    public final SelenideElement lstDriver = $(By.id("ext-comp-1094_SN"));
    public final SelenideElement lstTC = $(By.id("ext-comp-1095_SN"));
    public WndUploadFile uploader = new WndUploadFile();

    //frame
    public void select() {
        switchTo().defaultContent();
        switchTo().frame(I_FRAME);
        $(By.className("x-mask-loading")).waitUntil(Condition.not(Condition.present), 30000);
    }

    public static void closeProcessRequest() {
        switchTo().defaultContent();
        SelenideElement panelShippingRequestProcess = $(By.id("BaseMainContent_MainTabPanel__ShippingRequestProcess"));
        if (panelShippingRequestProcess.is(Condition.present))
            panelShippingRequestProcess.$(By.className("x-tab-strip-close")).click();
    }

    //main
    public void setDriver() {
        //$(By.id(wer("Driver"))).parent().$(By.className("x-form-arrow-trigger")).hover();
        $(By.id(wer("Driver"))).parent().$(By.className("x-form-twin-triggers")).$(By.className("x-form-arrow-trigger")).click();
        sleep(1000);
        ComboList.setFirst(lstDriver);
    }

    public void setTC() {
        //$(By.id(wer("TC"))).parent().$(By.className("x-form-arrow-trigger")).hover();
        $(By.id(wer("TC"))).parent().$(By.className("x-form-twin-triggers")).$(By.className("x-form-arrow-trigger")).click();
        sleep(2000);
        ComboList.setFirst(lstTC);
    }

    public String wer(String field) {
        String str = "Проверь подаваемое имя";
        for (SelenideElement el : $$(By.className("titlecomboline"))) {
            for (SelenideElement el1 : el.$$(By.className("x-form-text"))) {

                if (el1.name().contains(field)) {
                    str = el1.name();

                }

            }
        }
        return str;
    }

    //docs
    public void deleteDoc(String description) {
        $(By.linkText(description)).parent().$(By.cssSelector("a:nth-child(3) > img")).click();

    }
}
