package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.loginet.test.ojects.FilterRequest;


public class FilterShippingRequest extends FilterRequest {

    public FilterShippingRequest() {
        prefix = "MainContent_ctlContent_ctl04_";
        txtRequestName = $(By.id(idBuilder("txtRequestName")));

        dtpDateFrom = $(By.id(idBuilder("dtpDateFrom")));
        dtpDateTo = $(By.id(idBuilder("dtpDateTo")));

        txtSTO = $(By.id(idBuilder("txtSTO")));
        txtOD = $(By.id(idBuilder("txtOD")));
        txtShipment = $(By.id(idBuilder("txtShipment")));
        txtPO = $(By.id(idBuilder("txtPO")));

        cmbStatus = $(By.id(idBuilder("cmbStatus")));

        btnFilterApply = $(By.id(idBuilder("btnFilterApply")));
        btnFilterReset = $(By.id(idBuilder("btnFilterReset")));
        btnFilterCancel = $(By.id(idBuilder("btnFilterCancel")));
    }


    public void setOd(String od) {
        reset();
        ShippingRequest.btnFilter.click();
        txtOD.setValue(od);
        btnFilterApply.click();
        sleep(3000);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-col-OD")).shouldHave(Condition.text(od));//проверит первую линию и посмотрит в ней од


    }
}
