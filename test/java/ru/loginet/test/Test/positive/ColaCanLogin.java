package ru.loginet.test.Test.positive;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;
import ru.loginet.test.ojects.SideMenu;

/**
 * Created by supfe_000 on 18.09.2015.
 */
public class ColaCanLogin {
    @Test
    public void login(){
        new LoginPage("test_cola");
        SideMenu.openShRqwst();
    }
}
