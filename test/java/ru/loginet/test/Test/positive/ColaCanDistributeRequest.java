package ru.loginet.test.Test.positive;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequestDistribute;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * Created by supfe_000 on 17.09.2015.
 */
public class ColaCanDistributeRequest {
    String customer = "cola";
    String userName = "test_cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    String requestName = "255743";
    ShippingRequestDistribute requestDistribute = new ShippingRequestDistribute();
    String partner = "РегионТрансАвто";
    @Test
    public void colaCanDistributeRequest(){
        switchTo().frame(ShippingRequest.I_FRAME);
        shippingRequest.btnFilter.waitUntil(Condition.not(Condition.appear), 30000);
        shippingRequest.filterReset();
        shippingRequest.btnFilter.click();
        shippingRequest.filterShippingRequest.setDateNState(Dater.getTomorrow(), "Оформлена");
        sleep(3000);
        shippingRequest.getFirstChkrOnGrid().setSelected(true);
        shippingRequest.btnDistributeMenu.click();
        shippingRequest.mniDistribute.click();
        requestDistribute.distiributeRequestOnPartner(partner);

    }

}
