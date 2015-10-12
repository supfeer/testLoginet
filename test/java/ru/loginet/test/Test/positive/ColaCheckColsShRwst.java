package ru.loginet.test.Test.positive;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by tester_2 on 24.09.2015.
 */
public class ColaCheckColsShRwst {

    @Test
    public void checkCols() {
        /*new LoginPage("test_cola");*/
        ShippingRequest shippingRequest = new ShippingRequest("cola");
        SideMenu.openShRqwst();
        shippingRequest.filterReset();
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-checker")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-Options")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestName")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestDate")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestTime")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestService")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestStatus")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-col-RequestStatus")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestSender")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-Comment")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestReceiver")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-AssignedCustomer")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestRealTransportationPrice")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestDesiredTransportationPrice")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestVehicleType")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestTransportDirection")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-STO")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-OD")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-Shipment")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-PO")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-InvoiceName")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-LoadStoreCode")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestTotalCargoCost")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-UnloadStoreCode")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-Driver")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-Mobile")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RecipientCode")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-TripCount")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-WagonsCount")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-PlacesCount")).shouldBe(Condition.present);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-td-RequestQualityFeedbackValue")).shouldBe(Condition.present);
    }

}
