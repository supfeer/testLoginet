package ru.loginet.test.Test.negative;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

/**
 * Created by supfe_000 on 20.09.2015.
 */
public class ColaCannotDistributeRequest {
    ShippingRequest shippingRequest = new ShippingRequest("cola");

    @BeforeClass
    public void login() {
        new LoginPage("test_cola");
    }

    @BeforeTest
    public void openShRwst() {
        SideMenu.openShRqwst();
        shippingRequest.filterReset();
        shippingRequest.openFilter();
    }

    @Test
    public void cannotDistribute5daysAgo() {
        shippingRequest.filter.setDateLoadTo(Dater.get5daysAgo());
        shippingRequest.filter.setState("Оформлена");
        shippingRequest.filter.apply();
        shippingRequest.firstRow.click();
        shippingRequest.btnDistributeMenu.click();

    }
}
