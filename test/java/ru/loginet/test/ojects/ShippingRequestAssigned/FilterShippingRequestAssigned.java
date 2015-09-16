package ru.loginet.test.ojects.ShippingRequestAssigned;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.loginet.test.ojects.FilterRequest;

public class FilterShippingRequestAssigned extends FilterRequest{
    public FilterShippingRequestAssigned(){
        prefix = "MainContent_ctlContent_ctl44_";
        txtRequestName =    $(By.id(idBuilder("txtRequestName")));

        dtpDateFrom =       $(By.id(idBuilder("dtpDateFrom")));
        dtpDateTo =         $(By.id(idBuilder("dtpDateTo")));

        txtSTO =            $(By.id(idBuilder("txtSTO")));
        txtOD =             $(By.id(idBuilder("txtOD")));
        txtShipment =       $(By.id(idBuilder("txtShipment")));
        txtPO =             $(By.id(idBuilder("txtPO")));

        cmbStatus =         $(By.id(idBuilder("cmbStatus")));

        btnFilterApply =    $(By.id(idBuilder("btnFilterApply")));
        btnFilterReset =    $(By.id(idBuilder("btnFilterReset")));
        btnFilterCancel =   $(By.id(idBuilder("btnFilterCancel")));
    }

    @Override
    public void reset() {
        ShippingRequestAssigned.btnFilter.click();
        btnFilterReset.click();
        sleep(3000);
    }

    @Override
    public SelenideElement findLinkByRequestName(String requestName) {
        if ($(By.linkText(requestName)).is(Condition.not(Condition.present))) {
            reset();
            ShippingRequestAssigned.btnFilter.click();
            txtRequestName.setValue(requestName);
            btnFilterApply.click();
            sleep(3000);
        }
        return $(By.linkText(requestName));
    }
}
