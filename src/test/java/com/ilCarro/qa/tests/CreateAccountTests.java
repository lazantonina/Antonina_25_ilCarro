package com.ilCarro.qa.tests;

import com.ilCarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.header().isSignUpTabPresentInHeader()) {    //sign up not present
            app.header().clickLogout();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName("AS")
                .setlName("FV")
                .setEmail("oo@aa9.co")
                .setPassword("1234568Pp"));
        //click submit button
        app.session().submitForm();
        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
    }
}
