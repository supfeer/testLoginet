package ru.loginet.test.Test.positive.Transporter;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ProccessRequest;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;
import ru.loginet.test.ojects.SideMenu;
import ru.loginet.test.ojects.tools.Js;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * перевозчик стартует исполнение заявки у колы заполнив данные по водителям, тс, и приложив заявку для печати
 */
public class TransporterCanStartProcessRequestCola {
    ShippingRequestAssigned shippingRequestAssigned = new ShippingRequestAssigned();
    String rwstName;
    final String ORGANIZER = "ККЭБСЕ";
    final String state = "Подтверждена грузоотправителем";
    final String service = "Междугородняя перевозка";
    String price;
    final String TRANSPORTER = "stef";
    ProccessRequest proccessRequest = new ProccessRequest();
    File dummi = new File("src/test/testFiles/dummi.txt");
    String stamp = "Заявка для печати";
    String proxy = "Доверенность";

    @Test
    public void canSelectRwst() {
        new LoginPage(TRANSPORTER);
        SideMenu.openShRqwstAssigned();

        shippingRequestAssigned.filterReset();
        sleep(3000);
        shippingRequestAssigned.openFilter();
        shippingRequestAssigned.filter.setSender(ORGANIZER);
        shippingRequestAssigned.filter.setState(state);
        shippingRequestAssigned.filter.setService(service);
        //Тут будем выбирать услугу по контракту

        shippingRequestAssigned.filter.apply();
        shippingRequestAssigned.firstRow("x-grid3-row-checker").setSelected(true);
        price = shippingRequestAssigned.firstRow("x-grid3-col-Prices").getText();
        rwstName = shippingRequestAssigned.getRequestNameSelectedRequest();
        shippingRequestAssigned.btnProcess.click();


    }

    @Test(dependsOnMethods = {"canSelectRwst"})
    public void canAssignFromCola() {
        proccessRequest.select();
        proccessRequest.btnFinishProcess.shouldHave(Condition.cssClass("x-item-disabled"));
        proccessRequest.btnStartProcess.shouldHave(Condition.not(Condition.cssClass("x-item-disabled")));
        //Точки еще не инициализированы, проверим это
        $(By.className("x-grid3-col-expander")).shouldNotBe(Condition.exist);
        //$(By.className("x-grid3-col-expander")).name();
        Js.compare(proccessRequest.wer("Driver"), "Не указано");
        Js.compare(proccessRequest.wer("TC"), "Не указано");

    }

    @Test(dependsOnMethods = {"canAssignFromCola"})
    public void tryStart() {
        proccessRequest.btnStartProcess.click();
        $(By.className("x-window-dlg")).$(By.className("x-window-header-text"))
                .shouldHave(Condition.text("Ошибка при старте исполнения заявки"));
        System.out.println($(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .getText());
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Добавьте информацию о водителях для всех рейсов"));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Добавьте информацию о ТС для всех рейсов"));
        $(By.className("x-window-dlg")).$$(By.className("x-btn-mc")).findBy(Condition.text("OK")).click();
        proccessRequest.setDriver();
        proccessRequest.setTC();


        proccessRequest.btnStartProcess.click();
        $(By.className("x-window-dlg")).$(By.className("x-window-header-text"))
                .shouldHave(Condition.text("Ошибка при старте исполнения заявки"));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Приложите доверенность."));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Приложите заявку с печатью."));
        $(By.className("x-window-dlg")).$$(By.className("x-btn-mc")).findBy(Condition.text("OK")).click();
        proccessRequest.pnlRequestFiles.click();

        proccessRequest.btnUpload.click();
        proccessRequest.uploader.uploadSmt(dummi, stamp, stamp);
        proccessRequest.btnStartProcess.click();
        $(By.className("x-window-dlg")).$(By.className("x-window-header-text"))
                .shouldHave(Condition.text("Ошибка при старте исполнения заявки"));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Приложите доверенность."));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldNotHave(Condition.text("Приложите заявку с печатью."));
        $(By.className("x-window-dlg")).$$(By.className("x-btn-mc")).findBy(Condition.text("OK")).click();

        proccessRequest.deleteDoc(stamp);

        proccessRequest.btnUpload.click();
        proccessRequest.uploader.uploadSmt(dummi, proxy, proxy);
        proccessRequest.btnStartProcess.click();
        $(By.className("x-window-dlg")).$(By.className("x-window-header-text"))
                .shouldHave(Condition.text("Ошибка при старте исполнения заявки"));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldNotHave(Condition.text("Приложите доверенность."));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Приложите заявку с печатью."));
        $(By.className("x-window-dlg")).$$(By.className("x-btn-mc")).findBy(Condition.text("OK")).click();

        proccessRequest.btnUpload.click();
        proccessRequest.uploader.uploadSmt(dummi, stamp, stamp);

        proccessRequest.btnStartProcess.click();
        sleep(1000);
        proccessRequest.btnStartProcess.shouldBe(Condition.disabled);
        proccessRequest.btnFinishProcess.shouldHave(Condition.cssClass("x-item-disabled"));
        proccessRequest.btnStartProcess.click();
        //sleep(30000);
    }
    /*@AfterClass
    public void deleteRwst(){
        SqlTool.deleteRequest(rwstName);
    }*/
}
