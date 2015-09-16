package ru.loginet.test.Test.positive;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequestAssigned.FilterShippingRequestAssigned;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.sleep;


/**
 * Created by supfe_000 on 16.09.2015.
 */
public class Transporter {
    String userName = "tek20121";
    String requestName = "141609";
    FilterShippingRequestAssigned filterShippingRequestAssigned = new FilterShippingRequestAssigned();
    @Test

    public void openShippingRequestAssigned()
    {
        new LoginPage(userName);
        SideMenu.openShRqwstAssigned();

    }
    @Test(dependsOnMethods = { "openShippingRequestAssigned" })
    public void findRequest (){
        filterShippingRequestAssigned.findLinkByRequestName(requestName).parent().parent().parent().$(By.className("x-grid3-col-checker")).setSelected(true);

    }
    @Test(dependsOnMethods = { "findRequest" })
    public void userCanAssignRequest(){
        ShippingRequestAssigned.btnStartAccept.click();
        ShippingRequestAssigned.btnAcceptanceAccept.click();
        sleep(5000);
    }
}
