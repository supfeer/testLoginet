package ru.loginet.test.ojects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

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



    public abstract void reset();

    public abstract SelenideElement findLinkByRequestName(String requestName);

    public String idBuilder(String name){
        return prefix + name;
    }
}
