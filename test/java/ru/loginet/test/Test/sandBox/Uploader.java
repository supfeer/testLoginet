package ru.loginet.test.Test.sandBox;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.ProccessRequest;
import ru.loginet.test.ojects.ShippingRequestAssigned.ShippingRequestAssigned;
import ru.loginet.test.ojects.SideMenu;
import ru.loginet.test.ojects.WndUploadFile;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by supfe_000 on 28.09.2015.
 */
public class Uploader {
    File dummi = new File("src/test/testFiles/dummi.txt");

    @Test
    public void test() {
        new LoginPage("stef");
        ShippingRequestAssigned ass = new ShippingRequestAssigned();
        ProccessRequest proccessRequest = new ProccessRequest();
        WndUploadFile uploader = new WndUploadFile();
        SideMenu.openShRqwstAssigned();
        ass.firstCheker.click();
        ass.btnProcess.click();
        proccessRequest.select();

        proccessRequest.btnStartProcess.click();
        $(By.className("x-window-dlg")).$(By.className("x-window-header-text"))
                .shouldHave(Condition.text("Ошибка при старте исполнения заявки"));
        System.out.println($(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .getText());
        /*$(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Добавьте информацию о водителях для всех рейсов"));
        $(By.className("x-window-dlg")).$(By.className("ext-mb-text"))
                .shouldHave(Condition.text("Добавьте информацию о ТС для всех рейсов"));*/
        $(By.className("x-window-dlg")).$$(By.className("x-btn-mc")).findBy(Condition.text("OK")).click();


        proccessRequest.setDriver();
        proccessRequest.setTC();
        sleep(60000);
        /*proccessRequest.pnlRequestFiles.click();
        proccessRequest.btnUpload.click();
        uploader.uploadSmt(dummi,"123","Аукцион");
        sleep(30000);*/


    }
}
