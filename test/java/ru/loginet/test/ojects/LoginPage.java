package ru.loginet.test.ojects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class LoginPage extends Selenide {
    public final static SelenideElement userName = $(By.name("ctl00$MainContent$ctlContent$lgUserLogin$UserName"));
    public final static SelenideElement password= $(By.name("ctl00$MainContent$ctlContent$lgUserLogin$Password"));
    public final static SelenideElement loginBtn= $(By.name("ctl00$MainContent$ctlContent$lgUserLogin$LoginButton"));

        public LoginPage(String userlogin){
        open("http://iananova.loginet.ru/account/Login.aspx");
        userName.setValue(userlogin);
        password.setValue("542256" + userlogin);
        loginBtn.click();
    }

}
