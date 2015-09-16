package ru.loginet.test.ojects.ShippingRequest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

/**
 * Created by supfe_000 on 08.09.2015.
 */
public class RequestUploader4Auction extends Selenide{
    SelenideElement wndDialog_IFrame;

    SelenideElement linkTemplate;
    SelenideElement btnChoose;
    //Элементы всплывающего окна
    SelenideElement btnFind;
    SelenideElement btnUploadFile;
    SelenideElement btnClear;
    //Элементы, к-е появляются после загрузки файла
    SelenideElement btnSave;
    SelenideElement btnCancel;
    SelenideElement dsfTotalParced;//количество загруженных заявок
    SelenideElement dsfTotalIncorrect;//Количество неверных заявок
    public RequestUploader4Auction(String customer)
    {
        wndDialog_IFrame =      $(By.name("wndDialog_IFrame"));
        switch (customer) {

            case "okey":
                btnChoose =             $(By.id("BaseMainContent_ucFileUploader_btnChoose"));
                btnFind =               $(By.id("BaseMainContent_ucFileUploader_uplUploader-file"));
                btnUploadFile =         $(By.id("BaseMainContent_ucFileUploader_btnUpload"));
                btnSave =               $(By.className("x-tool x-tool-close"));
                //btnCancel =             $(By.id(""));
                //dsfTotalParced =        $(By.id(""));
                //dsfTotalIncorrect =     $(By.id(""));
                break;
            default:
                btnChoose =             $(By.id("BaseMainContent_ucFileUoloadXls4Auction_btnChoose"));
                btnFind =               $(By.id("BaseMainContent_ucFileUoloadXls4Auction_uplUploader-file"));
                btnUploadFile =         $(By.id("BaseMainContent_ucFileUoloadXls4Auction_btnUpload"));
                btnSave =               $(By.id("BaseMainContent_btnRequestsAuc"));
                btnCancel =             $(By.id("BaseMainContent_Button1"));
                dsfTotalParced =        $(By.id("BaseMainContent_dsfTotalParced"));
                dsfTotalIncorrect =     $(By.id("BaseMainContent_dsfTotalIncorrect"));
                break;

        }
    }
    public void UploadOneShippingRequest(File template)
    {

        switchTo().frame(wndDialog_IFrame);
        btnChoose.click();
        btnFind.uploadFile(template);
        sleep(1000);
        btnUploadFile.click();
        dsfTotalParced.shouldHave(Condition.text("1"));
        dsfTotalIncorrect.shouldHave(Condition.text("0"));
        btnSave.click();

        switchTo().parentFrame();

    }
}
