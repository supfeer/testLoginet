package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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
    protected SelenideElement cmbService;

    protected SelenideElement btnFilterApply;
    protected SelenideElement btnFilterReset;
    protected SelenideElement btnFilterCancel;



    public void reset() {
        btnFilterReset.click();
        sleep(3000);
    }

    public void setState(String state) {
        cmbStatus.click();
        sleep(2000);
        $$(By.className("x-mcombo-text")).findBy(Condition.text(state)).setSelected(true);


    }

    public void setService(String state) {
        cmbService.click();
        sleep(2000);
        $$(By.className("x-mcombo-text")).findBy(Condition.text(state)).setSelected(true);


    }
    public String idBuilder(String name){
        return prefix + name;
    }
    public void setDateLoad(String dateLoad){
        dtpDateFrom.setValue(dateLoad);
        dtpDateTo.setValue(dateLoad);
        //btnFilterApply.click();
    }

    public void setDateLoadFrom(String dateLoad) {
        dtpDateFrom.setValue(dateLoad);
    }

    public void setDateLoadTo(String dateLoad) {
        dtpDateTo.setValue(dateLoad);
    }
    public void setDateNState(String dateLoad,String state){
        cmbStatus.click();
        for (SelenideElement el:$(By.className("x-combo-list-inner")).$$(By.className("x-mcombo-text"))){
            if (el.getText().contains(state))
                el.setSelected(true);
        }
        dtpDateFrom.setValue(dateLoad);
        dtpDateTo.setValue(dateLoad);
    }

    public void setRequestName(String requestName) {
        txtRequestName.setValue(requestName);
    }

    public void apply() {
        btnFilterApply.click();
        sleep(2000);
    }

}
