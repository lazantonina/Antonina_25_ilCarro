package com.ilCarro.qa.tests;

import com.ilCarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;


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
                .setEmail("oo@aa10.com")
                .setPassword("1234568Pp"));
        //click submit button
        app.session().submitForm();
        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void testSignUpFromDataProvider(String fName, String lName, String email, String password) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName(fName)
                .setlName(lName)
                .setEmail(email)
                .setPassword(password));
        //click submit button
        app.session().submitForm();
        //check, login form displayed
        logger.info("Login form present. Actual result: " + app.session().isLoginFormPresent()
                + "  Expected result is: true");
        Assert.assertTrue(app.session().isLoginFormPresent());

    }

    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void testSignUpFromCSVDataProvider(User user) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(user);
        //click submit button
        app.session().submitForm();
        //check, login form displayed
        logger.info("Login form present. Actual result: " + app.session().isLoginFormPresent()
                + "  Expected result is: true");
        Assert.assertTrue(app.session().isLoginFormPresent());

    }
}
