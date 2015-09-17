package ru.loginet.test.Test.positive;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequestDistribute;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by supfe_000 on 17.09.2015.
 */
public class Distribute {
    String customer = "cola";
    String userName = "test_cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    String requestName = "255743";
    ShippingRequestDistribute requestDistribute = new ShippingRequestDistribute();
    String partner = "РегионТрансАвто";
    @Test
    public void userCanLogin(){
        new LoginPage(userName);
        SideMenu.openShRqwst();
        sleep(3000);
        shippingRequest.filterShippingRequest.setStatus("Оформлена");
        sleep(30000);
        shippingRequest.chkrOfRequest(requestName).setSelected(true);
        shippingRequest.btnDistributeMenu.click();
        shippingRequest.mniDistribute.click();
        requestDistribute.distiributeRequestOnPartner(partner);

    }

}
