package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;

/**
 * Created by supfe_000 on 10.09.2015.
 */
public abstract class FilterRequest extends Selenide{
    protected String prefix;

    protected SelenideElement txtRequestName;

    protected SelenideElement dtpDateFrom;
    protected SelenideElement dtpDateTo;

    protected SelenideElement txtSTO;
    protected SelenideElement txtOD;
    protected SelenideElement txtShipment;
    protected SelenideElement txtPO;

    protected SelenideElement cmbStatus;

    protected SelenideElement btnFilterApply;
    protected SelenideElement btnFilterReset;
    protected SelenideElement btnFilterCancel;



    public void reset() {
        btnFilterReset.click();
        sleep(3000);
    }

    public SelenideElement findLinkByRequestName(String requestName)
    {
        sleep(2000);
        if ($(By.linkText(requestName)).is(Condition.not(Condition.present))) {
            reset();
        }
        if ($(By.linkText(requestName)).is(Condition.not(Condition.present))) {

            txtRequestName.setValue(requestName);
            btnFilterApply.click();
        }

        return $(By.linkText(requestName));
    }

    public void setStatus(String state){
        cmbStatus.click();
        for (SelenideElement el:$(By.className("x-combo-list-inner")).$$(By.className("x-mcombo-text"))){
            if (el.getText().contains(state))
                el.setSelected(true);
        }

        btnFilterApply.click();
    }

    public String idBuilder(String name){
        return prefix + name;
    }
    public void setDateLoad(String dateLoad){
        dtpDateFrom.setValue(dateLoad);
        dtpDateTo.setValue(dateLoad);
        btnFilterApply.click();
    }
    public void setDateNState(String dateLoad,String state){
        cmbStatus.click();
        for (SelenideElement el:$(By.className("x-combo-list-inner")).$$(By.className("x-mcombo-text"))){
            if (el.getText().contains(state))
                el.setSelected(true);
        }
        dtpDateFrom.setValue(dateLoad);
        dtpDateTo.setValue(dateLoad);
        btnFilterApply.click();
    }

}
