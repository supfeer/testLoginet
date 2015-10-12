package ru.loginet.test.Test.sandBox;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ProccessRequest;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;
import ru.loginet.test.ojects.SideMenu;

/**
 * Created by supfe_000 on 25.09.2015.
 */
public class Rwst {
    ShippingRequestAssigned shippingRequestAssigned = new ShippingRequestAssigned();
    String rwstName;
    final String ORGANIZER = "ККЭБСЕ";
    final String state = "Подтверждена грузоотправителем";
    String price;
    final String TRANSPORTER = "stef";
    ProccessRequest proccessRequest = new ProccessRequest();

    @Test
    public void canSelectRwst() {
        new LoginPage(TRANSPORTER);
        SideMenu.openShRqwstAssigned();

        /*shippingRequestAssigned.filterReset();
        sleep(3000);
        shippingRequestAssigned.openFilter();
        shippingRequestAssigned.filter.setSender(ORGANIZER);
        shippingRequestAssigned.filter.setState(state);
        //Тут будем выбирать услугу по контракту*/

        //shippingRequestAssigned.filter.apply();
        shippingRequestAssigned.firstRow("x-grid3-row-checker").setSelected(true);
        price = shippingRequestAssigned.firstRow("x-grid3-col-Prices").getText();
        rwstName = shippingRequestAssigned.getRequestNameSelectedRequest();
        shippingRequestAssigned.btnProcess.click();


    }

    @Test(dependsOnMethods = {"canSelectRwst"})
    public void canAssignFromCola() {
        proccessRequest.select();
        //proccessRequest.btnFinishProcess.shouldBe(Condition.);
        proccessRequest.btnStartProcess.shouldBe(Condition.enabled);
        //Точки еще не инициализированы, проверим это
        //$(By.className("x-grid3-td-expander")).shouldBe(Condition.not(Condition.exist));
        System.out.println(proccessRequest.wer("Driver"));


    }
}
