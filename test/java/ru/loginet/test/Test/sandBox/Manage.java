package ru.loginet.test.Test.sandBox;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.SideMenu;

import static com.codeborne.selenide.Selenide.$;


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
        shippingRequest.filterReset();
        /*Selenide.$(By.linkText("226723")).click();
        sleep(5000);
        switchTo().defaultContent();
        switchTo().frame("ShippingRequestManage_IFrame");
        System.out.println();*/

        //System.out.println(SeleniumQuery.$("#MainContent_ctlContent_cmbShippingType").val());
        // System.out.println($().getText());
        //System.out.println(executeJavaScript("value",$(By.id("MainContent_ctlContent_cmbRequestService"))));
        //String str = executeJavaScript("return document.getElementById('MainContent_ctlContent_cmbRequestService').value");
        //System.out.println(str);
        $(By.className("x-grid3-row-first")).$(By.className("x-grid3-col-RequestTime")).shouldBe(Condition.present);
    }

}
