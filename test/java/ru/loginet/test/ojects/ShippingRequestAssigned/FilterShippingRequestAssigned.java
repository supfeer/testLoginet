package ru.loginet.test.ojects.ShippingRequestAssigned;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.loginet.test.ojects.FilterRequest;

public class FilterShippingRequestAssigned extends FilterRequest{
    SelenideElement sender;
    public FilterShippingRequestAssigned(){
        prefix = "MainContent_ctlContent_ctl44_";
        txtRequestName =    $(By.id(idBuilder("txtRequestName")));

        dtpDateFrom = $(By.id(idBuilder("dtpLoadDateFrom")));
        dtpDateTo = $(By.id(idBuilder("dtpLoadDateTo")));

        txtSTO =            $(By.id(idBuilder("txtSTO")));
        txtOD =             $(By.id(idBuilder("txtOD")));
        txtShipment =       $(By.id(idBuilder("txtShipment")));
        txtPO =             $(By.id(idBuilder("txtPO")));

        cmbStatus =         $(By.id(idBuilder("cmbStatus")));
        cmbService = $(By.id(idBuilder("cmbService")));


        sender = $(By.id(idBuilder("sbsSender")));

        btnFilterApply =    $(By.id(idBuilder("btnFilterApply")));
        btnFilterReset =    $(By.id(idBuilder("btnFilterReset")));
        btnFilterCancel =   $(By.id(idBuilder("btnFilterCancel")));

    }

    /*@Override
    public void reset() {
        ShippingRequestAssigned.btnFilter.click();
        btnFilterReset.click();
        sleep(2000);
    }

    @Override
    public SelenideElement setRequestName(String requestName) {
        if ($(By.linkText(requestName)).is(Condition.not(Condition.present))) {
            reset();
            ShippingRequestAssigned.btnFilter.click();
            txtRequestName.setValue(requestName);
            btnFilterApply.click();
            sleep(3000);
        }
        return $(By.linkText(requestName));
    }*/

    public void setSender(String customer) {
        sender.click();
        sender.setValue(customer);
        sleep(1000);
        sender.pressEnter();
    }

    @Override
    public void setState(String state) {
        cmbStatus.click();
        for (SelenideElement el : $$(By.className("lstState"))) {
            for (SelenideElement el1 : el.$$(By.className("x-mcombo-text"))) {
                if (el1.getText().contains(state))
                    el1.parent().setSelected(true);
            }
        }
        sleep(2000);
    }
}
