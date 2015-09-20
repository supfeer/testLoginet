package ru.loginet.test.Test.sandBox;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.Dater;
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
    ShippingRequestAssigned shippingRequestAssigned = new ShippingRequestAssigned();
    @Test
    public void openShippingRequestAssigned()
    {
        new LoginPage(userName);
        SideMenu.openShRqwstAssigned();

    }
    @Test(dependsOnMethods = { "openShippingRequestAssigned" })
    public void findRequest (){
        //filterShippingRequestAssigned.setRequestName(requestName).parent().parent().parent().$(By.className("x-grid3-col-checker")).setSelected(true);
        shippingRequestAssigned.filter.reset();
        shippingRequestAssigned.btnFilter.click();
        shippingRequestAssigned.filter.setSender("ККЭБСЕ");
        shippingRequestAssigned.filter.setDateLoad(Dater.getTomorrow());
        shippingRequestAssigned.filter.apply();
    }
    @Test(dependsOnMethods = { "findRequest" })
    public void userCanAssignRequest(){
        shippingRequestAssigned.btnStartAccept.click();
        shippingRequestAssigned.btnAcceptanceAccept.click();
        sleep(5000);
    }
}
