package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.loginet.test.ojects.ShippingRequest.ShippingRequest;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;


public class SideMenu extends Selenide{
    public final static SelenideElement transBrkr = $(By.xpath("//a[@onclick=\"__doPostBack('ctl00$ctl00$BaseMainContent$mnuNavigationTopMenu','Транспортный брокер')\"]"));
    public final static SelenideElement shippingRqwst = $(By.xpath("//a[contains(text(),'Собственные заявки')]"));
    public final static SelenideElement shippingRqwstAssigned= $(By.xpath("//a[contains(text(),'Полученные заявки')]"));

    public final static SelenideElement tndrBrkr = $(By.xpath("//a[@onclick=\"__doPostBack('ctl00$ctl00$BaseMainContent$mnuNavigationTopMenu','Тендерный брокер')\"]"));
    public final static SelenideElement mngVhcl = $(By.xpath("//a[@onclick=\"__doPostBack('ctl00$ctl00$BaseMainContent$mnuNavigationTopMenu','Управление автопарком')\"]"));
    public final static SelenideElement partner = $(By.xpath("//a[@onclick=\"__doPostBack('ctl00$ctl00$BaseMainContent$mnuNavigationTopMenu','Партнеры')\"]"));
    public final static SelenideElement cabinet = $(By.xpath("//a[@onclick=\"__doPostBack('ctl00$ctl00$BaseMainContent$mnuNavigationTopMenu','Кабинет')\"]"));



    public static void openShRqwst(){

        if (transBrkr.is(Condition.not(Condition.present))){
            refresh();

        }
        transBrkr.click();
        shippingRqwst.click();
        ShippingRequest.select();
    }
    public static void openShRqwstAssigned(){

        if (transBrkr.is(Condition.not(Condition.present))){
            refresh();

        }
        transBrkr.click();
        shippingRqwstAssigned.click();
        ShippingRequestAssigned.select();
    }

}
