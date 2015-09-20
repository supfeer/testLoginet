package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;


public class ShippingRequest extends Selenide {
    //I_FRAME
    public final static SelenideElement I_FRAME = $(By.name("ShippingRequestList_IFrame"));
    //header
    public SelenideElement pnlShippingRequestList;
    public SelenideElement frmRequestsList;
    public SelenideElement ShippingRequestList_IFrame;
     //toolbar
    public SelenideElement mnuAddRequest;
    public SelenideElement btnLoad;
    public     SelenideElement btnAddPen;
    public     SelenideElement btnCopy;
    public     SelenideElement btnLoadFromExcel;//Для окей?
    public     SelenideElement btnLoadXls4Auction;//Cola
    public     SelenideElement btnLoadXlsMultipleTemplates;//Metro
    public     SelenideElement btnLoadXlsTransferencesDialog;//Загрузка перемещений Окей
    public     SelenideElement btnLoadStoreData;//Загрузка данных со складов Орифлэйм
    public final SelenideElement btnDelete = $(By.id("MainContent_ctlContent_btnDeleteRequest"));
        public SelenideElement btnDeleteYes = $(By.id("ext-comp-1117"));
    public SelenideElement btnDistributeMenu;
        public SelenideElement mniDistribute;
        public SelenideElement mniAutoDitribute;
        public SelenideElement mniWarr;
        public SelenideElement mnuDistributeToOwnVehicle;
    public SelenideElement btnMakeDecisionOnRequest;
    public SelenideElement btnViewProcess;//кнопка исполнение
    public SelenideElement mnuViewProcess;//менюшка исполнение
    public SelenideElement btnQualityFeedback;
    public SelenideElement btnReports;
    final SelenideElement btnFilter;
    public SelenideElement btnDownloadDocs;
    public SelenideElement btnSAP;
    //x-grid
    public final SelenideElement firstRow = $(By.className("x-grid3-row-first"));
    public final static SelenideElement firstCheker = $(By.className("x-grid3-row-checker"));
    public final SelenideElement options = $(By.className("x-grid3-td-Options"));
    public SelenideElement requestName = $(By.className("x-grid3-td-RequestName"));
    public final SelenideElement od = $(By.className("x-grid3-td-OD"));
    public final SelenideElement requestDate = $(By.className("x-grid3-col-RequestDate"));
    public SelenideElement requestTime;

    //pagenator
    public final SelenideElement countOfRow = $(By.id("MainContent_ctlContent_ptlbReq")).$(By.className("x-toolbar-right-row")).$(By.className("xtb-text"));
    //objects
    public RequestUploader requestUploader;
    public FilterShippingRequest filter;

    public ShippingRequest(String customer)
    {
        mnuAddRequest = $(By.id("MainContent_ctlContent_mnuAddRequest"));
        switch (customer) {
            case "cola":
                btnLoad = $(By.id("MainContent_ctlContent_btnLoadXls4Auction"));
                break;
            case "okey":
                btnLoad = $(By.id("MainContent_ctlContent_btnLoadFromExcel"));
                break;
            case "metro":
                btnLoad = $(By.id("MainContent_ctlContent_btnLoadXlsMultipleTemplates"));
                break;
            default:
                btnLoad = $(By.id("MainContent_ctlContent_btnLoadXls4Auction"));
                break;
        }
        btnDistributeMenu = $(By.id("MainContent_ctlContent_btnDistributeMenu"));
        mniWarr = $(By.id("x-menu-el-MainContent_ctlContent_mniWarr"));
        mniDistribute = $(By.id("MainContent_ctlContent_mniDistribute"));
        btnFilter = $(By.id("MainContent_ctlContent_btnFilter"));
        requestUploader = new RequestUploader(customer);
        filter = new FilterShippingRequest();
        //xgrid



    }

    public static void select()
    {
        switchTo().defaultContent();
        switchTo().frame(I_FRAME);
    }
    public ArrayList<SelenideElement> getWholeGrid(){
        return new ArrayList<SelenideElement>($$(By.className("x-grid3-row")));
    }
    public SelenideElement getFirstChkrOnGrid(){
        return $(By.className("x-grid3-row-first")).$(By.className("x-grid3-row-checker"));
    }
    public SelenideElement chkrOfRequest(String requestName){
        return filter.findLinkByRequestName(requestName).parent().parent().parent().$(By.className("x-grid3-col-checker"));
    }



    //Filter
    public void openFilter() {
        btnFilter.click();
    }
    public void filterReset(){
        btnFilter.click();
        filter.reset();
        sleep(2000);
    }
    public void filterSetDateLoad(String dateLoad){
        btnFilter.click();
        filter.setDateLoad(dateLoad);
        filter.apply();
    }

    public SelenideElement filterFindByOd(String od) {
        filter.setOd(od);
        filter.apply();
        sleep(3000);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-col-OD")).shouldHave(Condition.text(od));//проверит первую линию и посмотрит в ней од
        return $(By.className("x-grid3-row-first")).$(By.className("x-grid3-col-RequestName"));
    }

    public void filterFindByName(String requestName) {
        filterReset();
        btnFilter.click();
        filter.setRequestName(requestName);
        filter.apply();
        $(By.linkText(requestName)).shouldBe(Condition.present);
    }

    //xgrig
    public SelenideElement firstRow(String cellOnRow) {
        return firstRow.$(By.className(cellOnRow));
    }

    public String getRequestNameSelectedRequest() {
        return $(By.className("x-grid3-row-selected")).$(By.className("x-grid3-col-RequestName")).getText();
    }

    //
    public void deleteRequest(String requestName) {
        $(By.linkText(requestName)).parent().parent().parent().parent().$(By.className("x-grid3-row-checker")).setSelected(true);
        btnDelete.click();
        //хрен поймешь вообще почему в яндексе ид постоянно один и тот же, а в мозиле меняется, потому этот очень грязный хак
        for (SelenideElement el : $$(By.id("ext-comp-1118"))) {
            if (el.is(Condition.visible))
                el.click();
        }
        //btnDeleteYes.click();
        countOfRow.shouldHave(Condition.text("Нет данных для отображения"));
    }
}
