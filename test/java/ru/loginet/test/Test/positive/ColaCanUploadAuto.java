package ru.loginet.test.Test.positive;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.cola.ParserShippingRequestCola;
import ru.loginet.test.cola.ShippingRequestValueContainerCola;
import ru.loginet.test.ojects.Dater;
import ru.loginet.test.ojects.ShippingRequest.*;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.SideMenu;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;


public class ColaCanUploadAuto

{
    ParserShippingRequestCola parser = new ParserShippingRequestCola();

    ShippingRequestValueContainerCola containerCola = parser.parseToContainer();
    File template = new File(containerCola.getFile_path());
    String customer = "cola";
    ShippingRequest shippingRequest = new ShippingRequest(customer);
    @Test
    public void ColaCanUploadIntercityShippingRequest()
    {
        try {
            ParserShippingRequestCola.setOd();
            ParserShippingRequestCola.setDateLoad(Dater.getTomorrow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        shippingRequest.mnuAddRequest.click();
        shippingRequest.btnLoad.click();
        shippingRequest.requestUploader.UploadOneShippingRequest(template);
    }

}
