package ru.loginet.test.Test.sandBox;


import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

/**
 * Created by supfe_000 on 18.09.2015.
 */
public class UserCanUploadShRwst {
    String customer = "cola";
    String userName = "test_cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    @Test
    public void upload() throws Exception {
        ParserShippingRequestCola.setDateLoad(Dater.getTomorrow());
        new LoginPage(userName);
        SideMenu.openShRqwst();


    }
}
