package ru.loginet.test.Test.positive;

import org.testng.annotations.Test;
import ru.loginet.test.ojects.LoginPage;

/**
 * Created by supfe_000 on 18.09.2015.
 */
public class ColaCanLogin {
    @Test
    public void login(){
        new LoginPage("test_cola");
    }
}
