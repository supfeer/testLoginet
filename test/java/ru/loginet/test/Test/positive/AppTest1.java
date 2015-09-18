package ru.loginet.test.Test.positive;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.cola.ShippingRequestValueContainerCola;
import ru.loginet.test.ojects.ShippingRequest.*;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.SideMenu;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;


public class AppTest1

{
    ParserShippingRequestCola parser = new ParserShippingRequestCola();
    ShippingRequestValueContainerCola containerCola = parser.parseToContainer();
    File template = new File(containerCola.getFile_path());
    String customer = "cola";
    String userName = "test_cola";
    String userPassword = "542256test_cola";


    ShippingRequest shippingRequest = new ShippingRequest(customer);

    FilterShippingRequest filterShippingRequest = new FilterShippingRequest();

    @Test
    public void ColaCanUploadIntercityShippingRequest()
    {
        new LoginPage(userName);
        SideMenu.openShRqwst();//Нажмет на собственные заявки, дождется загрузки грида и перейдет на него
        shippingRequest.mnuAddRequest.click();
        shippingRequest.btnLoad.click();
        shippingRequest.requestUploader.UploadOneShippingRequest(template);
    }
    @Test(dependsOnMethods = {"ColaCanUploadIntercityShippingRequest"})

    public void ColaCanFindByOd() {
        filterShippingRequest.setOd(containerCola.getOD());
        System.out.println("ColaCanFindByOd");
    }

    @Test(dependsOnMethods = { "ColaCanFindByOd" })

    public void colaCanDistributeByWarr(){
        //shippingRequest.btnDistributeMenu.click();
        //shippingRequest.mniWarr.click();
        //ShippingRequestWarranty.distribute();
        //System.out.println("colaCanDistributeByWarr");
    }
    @Test(dependsOnMethods = {"colaCanDistributeByWarr"})

    public void colaCanDistributeOnPartner(){
        //shippingRequest.getFirstChkrOnGrid().setSelected(true);
        shippingRequest.btnDistributeMenu.click();
        shippingRequest.mniDistribute.click();
        sleep(30000);
        switchTo().defaultContent();
        switchTo().frame(ShippingRequestDistribute.iFrame);
        $(By.id("ext-gen21-gp-PartnerName-ООО \"Алые Паруса\"-bd")).waitUntil(Condition.not(Condition.present), 30000);
        $(By.id("ext-gen21-gp-PartnerName-ООО \"Алые Паруса\"-bd")).$(By.className("x-grid3-cell-first")).click();
        sleep(3000);
        $(By.id("MainContent_ctlContent_gplContactPersons")).$(By.className("x-grid3-scroller")).$(By.className("x-grid3-row-first")).$(By.className("x-grid3-row-checker")).setSelected(true);
        $(By.id("MainContent_ctlContent_btnSendMail"));
        switchTo().defaultContent();
        switchTo().frame(ShippingRequest.I_FRAME);
        System.out.println("Success");
        sleep(30000);
    }


}
