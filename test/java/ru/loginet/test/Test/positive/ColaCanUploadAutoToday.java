package ru.loginet.test.Test.positive;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.cola.ShippingRequestValueContainerCola;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;
import ru.loginet.test.ojects.tools.Dater;

import java.io.File;

/**
 * Created by supfe_000 on 20.09.2015.
 */
public class ColaCanUploadAutoToday {

    ShippingRequestValueContainerCola containerCola = new ShippingRequestValueContainerCola();
    File template = new File(containerCola.getFile_path());
    String customer = "cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);


    @Test
    public void ColaCanUploadIntercityShippingRequest() throws Exception {
        new LoginPage("test_cola");

        SideMenu.openShRqwst();
        try {
            ParserShippingRequestCola.setOd();
            ParserShippingRequestCola.setDateLoad(Dater.getToday());

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
        containerCola.setRequestName(shippingRequest.getNameFromComment(containerCola.getComment()));
    }

    @Test(dependsOnMethods = {"findRequest"})
    public void checkGrid() {
        //shippingRequest.firstRow("x-grid3-col-Options").should(Condition.attribute("img"));
        // shippingRequest.firstRow("x-grid3-col-Options").shouldHave();
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
        //shippingRequest.deleteRequest(containerCola.getRequestName());
    }
}
