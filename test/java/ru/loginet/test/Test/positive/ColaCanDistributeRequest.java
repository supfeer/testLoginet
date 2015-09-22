package ru.loginet.test.Test.positive;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequestDistribute;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by supfe_000 on 17.09.2015.
 */
public class ColaCanDistributeRequest {
    String customer = "cola";
    String userName = "test_cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    String requestName = "";
    ShippingRequestDistribute requestDistribute = new ShippingRequestDistribute();
    String partner = "ООО\"СТЭФ\"";

    //"РегионТрансАвто";
    //
    @Test
    public void colaCanDistributeRequest(){
        SideMenu.openShRqwst();
        shippingRequest.filterReset();
        shippingRequest.openFilter();
        shippingRequest.filter.setDateNState(Dater.getTomorrow(), "Оформлена");
        shippingRequest.filter.apply();
        sleep(2000);
        shippingRequest.getFirstChkrOnGrid().setSelected(true);
        requestName = shippingRequest.getRequestNameSelectedRequest();
        shippingRequest.btnDistributeMenu.click();
        shippingRequest.mniDistribute.click();
        requestDistribute.distiributeRequestOnPartner(partner);
        shippingRequest.filterFindByName(requestName);
        $(By.linkText(requestName)).parent().parent().parent().
                $(By.className("x-grid3-col-AssignedCustomer")).
                shouldHave(Condition.text(partner));
    }

}
