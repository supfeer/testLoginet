package ru.loginet.test.Test.sandBox;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by supfe_000 on 19.09.2015.
 */
public class Manage {
    @Test
    public void login() {
        new LoginPage("test_cola");
        ShippingRequest shippingRequest = new ShippingRequest("cola");
        SideMenu.openShRqwst();
        //$(By.linkText("255912")).click();
        shippingRequest.openFilter();
        sleep(10000);
        //switchTo().defaultContent();
        //switchTo().frame("ShippingRequestManage_IFrame");
        //System.out.println($(By.id("ext-gen74")).getText());
        switchTo().defaultContent();
        $(By.id("BaseMainContent_MainTabPanel__ShippingRequestList")).$(By.className("x-tab-strip-close")).click();
        refresh();
        SideMenu.openShRqwst();
        sleep(5000);
        shippingRequest.openFilter();
        sleep(10000);
        SideMenu.openShRqwstAssigned();
        sleep(10000);
        SideMenu.openShRqwst();
        shippingRequest.openFilter();
        sleep(10000);
    }
}
