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
    public final SelenideElement btnStartAccept = $(By.id("MainContent_ctlContent_btnStartAccept"));
    public static final SelenideElement btnStartCancel = $(By.id("MainContent_ctlContent_btnCancel"));

    public static final SelenideElement btnInsure = $(By.id("MainContent_ctlContent_btnInsure"));
    public static final SelenideElement btnProcess = $(By.id("MainContent_ctlContent_btnProcess"));
    public final SelenideElement btnFilter = $(By.id("MainContent_ctlContent_btnFilter"));
    public static final SelenideElement mnuReports = $(By.id("MainContent_ctlContent_btnReports"));
    //public static final SelenideElement btnCreateBill = $(By.id("MainContent_ctlContent_btnCreateBill"));

    public FilterShippingRequestAssigned filter;
    //xgrid
    public final SelenideElement firstRow = $(By.className("x-grid3-row-first"));
    public final SelenideElement firstCheker = $(By.className("x-grid3-row-checker"));
    //Assignator
    public final SelenideElement btnAcceptanceAccept = $(By.id("MainContent_ctlContent_btnAccept"));
    public final SelenideElement txtPriceForTheRequest = $(By.id("MainContent_ctlContent_txtPriceForTheRequest"));

    //constuctor
    public ShippingRequestAssigned() {
        filter = new FilterShippingRequestAssigned();

    }
    public static void select()
    {
        switchTo().defaultContent();
        switchTo().frame(I_FRAME);
    }

    //xgrig
    public SelenideElement firstRow(String classOfCellOnRow) {
        return firstRow.$(By.className(classOfCellOnRow));
    }

    public String getRequestNameSelectedRequest() {
        return $(By.className("x-grid3-row-selected")).$(By.className("x-grid3-td-1")).getText();
    }

    //filter
    public void showDistributedFrom(String customer, String state) {
        filter.reset();
        btnFilter.click();
        filter.setState(state);
        filter.setSender(customer);

    }

    public void filterReset() {
        btnFilter.click();
        filter.reset();
        sleep(2000);
    }

    public void openFilter() {
        btnFilter.click();
    }

    public void filterFindByName(String requestName) {
        filterReset();
        btnFilter.click();
        filter.setRequestName(requestName);
        filter.apply();
        $(By.linkText(requestName)).shouldBe(Condition.present);
    }
}
