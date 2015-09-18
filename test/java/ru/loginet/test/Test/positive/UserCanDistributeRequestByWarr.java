package ru.loginet.test.Test.positive;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequestWarranty;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class UserCanDistributeRequestByWarr {
    String customer = "cola";
    String userName = "test_cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    @Test
    public void test(){
        shippingRequest.btnDistributeMenu.click();
        shippingRequest.mniWarr.click();
        ShippingRequestWarranty.distribute();
    }
}
