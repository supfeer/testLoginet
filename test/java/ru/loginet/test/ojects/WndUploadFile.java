package ru.loginet.test.ojects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

/**
 * Created by supfe_000 on 28.09.2015.
 */
public class WndUploadFile extends Selenide {
    public final SelenideElement btnFind = $(By.id("MainContent_ctlContent_uplFiles_uplUploader-file"));
    public final SelenideElement txtDescription = $(By.id("MainContent_ctlContent_uplFiles_txtDescription"));
    public final SelenideElement ddlType = $(By.id("MainContent_ctlContent_uplFiles_ddlType"));
    public final SelenideElement btnUpload = $(By.id("MainContent_ctlContent_uplFiles_btnUpload"));
    public final SelenideElement lst = $(By.id("ext-comp-1096_SN"));

    @Deprecated
    public void setType(String typeDocument) {
        ComboList.setType(lst, typeDocument);
    }

    public void uploadSmt(File dummi, String description, String typeDocument) {
        btnFind.uploadFile(dummi);
        txtDescription.setValue(description);
        ddlType.click();
        setType(typeDocument);
        btnUpload.click();
        $(By.linkText(description)).shouldBe(Condition.present);
        $(By.linkText(description)).parent().parent().parent()
                .$(By.className("x-grid3-col-clnFileDescription")).shouldHave(Condition.text(typeDocument));

    }
}
