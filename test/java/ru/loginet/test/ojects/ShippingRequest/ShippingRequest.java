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
    public SelenideElement btnDelete;
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
    public final static SelenideElement btnFilter = $(By.id("MainContent_ctlContent_btnFilter"));
    public SelenideElement btnDownloadDocs;
    public SelenideElement btnSAP;
    //x-grid
    public final static SelenideElement firstCheker = $(By.className("x-grid3-row-checker"));
    public RequestUploader requestUploader;
    public FilterShippingRequest filterShippingRequest;

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
        requestUploader = new RequestUploader(customer);
        filterShippingRequest = new FilterShippingRequest();
    }

    public static void select()
    {
        if(I_FRAME.is(Condition.visible))
        {
            switchTo().frame(I_FRAME);
        }else {
            switchTo().defaultContent();
            switchTo().frame(I_FRAME);
        }
    }
    public ArrayList<SelenideElement> getWholeGrid(){
        return new ArrayList<SelenideElement>($$(By.className("x-grid3-row")));
    }
    public SelenideElement getFirstChkrOnGrid(){
        return $(By.className("x-grid3-row-first")).$(By.className("x-grid3-row-checker"));
    }
    public SelenideElement chkrOfRequest(String requestName){
        return filterShippingRequest.findLinkByRequestName(requestName).parent().parent().parent().$(By.className("x-grid3-col-checker"));
    }
}
