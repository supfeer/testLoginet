package ru.loginet.test.Test.positive;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.cola.ShippingRequestValueContainerCola;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;


public class ColaCanUploadAuto

{
    ShippingRequestValueContainerCola containerCola = new ShippingRequestValueContainerCola();
    File template = new File(containerCola.getFile_path());
    String customer = "cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);


    @Test
    public void ColaCanUploadIntercityShippingRequest() throws Exception {

        SideMenu.openShRqwst();
        try {
            ParserShippingRequestCola.setOd();
            ParserShippingRequestCola.setDateLoad(Dater.getTomorrow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        containerCola = ParserShippingRequestCola.parseToContainer();
        shippingRequest.mnuAddRequest.click();
        shippingRequest.btnLoad.click();
        shippingRequest.requestUploader.UploadOneShippingRequest(template);
    }

    @Test(dependsOnMethods = {"ColaCanUploadIntercityShippingRequest"})
    public void findRequest() {
        shippingRequest.filterReset();
        shippingRequest.openFilter();
        shippingRequest.filter.setOd(containerCola.getOD());
        shippingRequest.filter.apply();
        shippingRequest.countOfRow.shouldHave(Condition.text("Отображаются записи с 1 по 1, всего 1"));
        shippingRequest.firstRow.$(By.className("x-grid3-col-OD")).shouldHave(Condition.text(containerCola.getOD()));
        containerCola.setRequestName($(By.className("x-grid3-col-RequestName")).getText());
    }

    @Test(dependsOnMethods = {"findRequest"})
    public void checkGrid() {
        shippingRequest.firstRow("x-grid3-col-RequestDate").shouldHave(Condition.text(containerCola.getRequestDate()));
        shippingRequest.firstRow("x-grid3-col-RequestTime").shouldHave(Condition.text(containerCola.getRequestTime()));
        shippingRequest.firstRow("x-grid3-col-RequestStatus").shouldHave(Condition.text("Оформлена"));
        shippingRequest.firstRow("x-grid3-col-RequestSender").shouldHave(Condition.text("ККЭБСЕ"));
        shippingRequest.firstRow("x-grid3-col-RequestReceiver").shouldHave(Condition.text(containerCola.getAdressUnload()));
        shippingRequest.firstRow("x-grid3-col-AssignedCustomer").shouldHave(Condition.text("Не указано"));
        shippingRequest.firstRow("x-grid3-col-RequestDesiredTransportationPrice").shouldHave(Condition.text("33250 RUR"));
        shippingRequest.firstRow("x-grid3-col-RequestVehicleType").shouldHave(Condition.text(containerCola.getVehicleType()));
        shippingRequest.firstRow("x-grid3-col-RequestService").shouldHave(Condition.text(containerCola.getRequestService()));
        shippingRequest.firstRow("x-grid3-col-LoadStoreCode").shouldHave(Condition.text(containerCola.getLoadStoreCode()));

        shippingRequest.firstRow("x-grid3-col-UnloadStoreCode").shouldHave(Condition.text(containerCola.getUnloadStoreCode()));
        shippingRequest.firstRow("x-grid3-col-RequestTotalCargoCost").shouldHave(Condition.text(containerCola.getRequestTotalCargoCost()));
        shippingRequest.firstRow("x-grid3-col-LoadStoreCode").shouldHave(Condition.text(containerCola.getLoadStoreCode()));
        shippingRequest.firstRow("x-grid3-col-LoadStoreCode").shouldHave(Condition.text(containerCola.getLoadStoreCode()));
        shippingRequest.firstRow("x-grid3-col-LoadStoreCode").shouldHave(Condition.text(containerCola.getLoadStoreCode()));
        shippingRequest.firstRow("x-grid3-col-LoadStoreCode").shouldHave(Condition.text(containerCola.getLoadStoreCode()));
        shippingRequest.deleteRequest(containerCola.getRequestName());

    }

    @Test(dependsOnMethods = {"checkGrid"})
        public void chekOnManage(){
            $(By.linkText(containerCola.getRequestName())).click();
        switchTo().defaultContent();
        sleep(10000);
        switchTo().frame("ShippingRequestManage_IFrame");
        System.out.println($(By.name("MainContent_ctlContent_cmbRequestService")).getText());
        if (!executeJavaScript("return document.getElementById('MainContent_ctlContent_cmbRequestService').value").equals(containerCola.getRequestService()))
            $(By.id("RequestServiceweer")).click();
    }

}
