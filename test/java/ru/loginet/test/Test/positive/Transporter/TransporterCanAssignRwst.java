package ru.loginet.test.Test.positive.Transporter;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;
import ru.loginet.test.ojects.SideMenu;
import ru.loginet.test.ojects.tools.Pricer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by supfe_000 on 20.09.2015.
 */
public class TransporterCanAssignRwst {
    ShippingRequestAssigned shippingRequestAssigned = new ShippingRequestAssigned();
    String rwstName;
    final String state = "Распределена";
    String price;


    @Test
    public void canAssignFromCola() {
        new LoginPage("stef");
        SideMenu.openShRqwstAssigned();

        shippingRequestAssigned.filterReset();
        sleep(3000);
        shippingRequestAssigned.openFilter();
        shippingRequestAssigned.filter.setSender("ККЭБСЕ");
        shippingRequestAssigned.filter.setState(state);
        shippingRequestAssigned.filter.apply();
        shippingRequestAssigned.firstRow("x-grid3-row-checker").setSelected(true);
        price = shippingRequestAssigned.firstRow("x-grid3-col-Prices").getText();

        rwstName = shippingRequestAssigned.getRequestNameSelectedRequest();

        if (shippingRequestAssigned.firstRow("x-grid3-col-Prices").getText().contains("Оплата согласно договора перевозки грузов")) {
            System.out.println("Booom!!!");
        } else {
            shippingRequestAssigned.btnStartAccept.click();
            shippingRequestAssigned.txtPriceForTheRequest.shouldBe(Condition.disabled);
            shippingRequestAssigned.assignatorComparePrices();
            shippingRequestAssigned.btnAcceptanceAccept.click();
            shippingRequestAssigned.filterFindByName(rwstName);
            System.out.println($(By.linkText(rwstName))
                    .parent().parent().parent().$(By.className("x-grid3-col-Prices")).getText());
            //Сравнивает ставки и если они не совпадают происходит айайай
            if (!Pricer.compare($(By.linkText(rwstName))
                    .parent().parent().parent().$(By.className("x-grid3-col-Prices")).getText())) {
                System.out.println("Boooooooooooooom");
                $(By.className("Prices not equals"));
            }
        }
    }

}
