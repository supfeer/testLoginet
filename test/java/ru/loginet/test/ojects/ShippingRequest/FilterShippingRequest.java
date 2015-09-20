package ru.loginet.test.ojects.ShippingRequest;

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
        txtOD.setValue(od);
    }
}
