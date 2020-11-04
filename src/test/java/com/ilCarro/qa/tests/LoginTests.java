package com.ilCarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.session().isLoginFormPresent()) {
            if(app.session().isUserLoggedIn()){
                app.header().clickLogout();
            }
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() throws InterruptedException {
        //oo@aa.com
        //oo@aa1.com
        //oo@aa2.com
        app.session().login("oo@aa7.com", "1234568Pp");
        //Assert.assertTrue(app.session().isUserLoggedIn());

    }
}
