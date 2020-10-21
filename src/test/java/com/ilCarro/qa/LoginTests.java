package com.ilCarro.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        //go to login page
        if(!app.getUser().isLoginFormPresent()){

            if(app.getUser().isUserLoggedIn()){
                app.getUser().logOut();
            }
            app.getHeader().clickLoginTabOnHeader();
        }

    }

    @Test
    public void loginRegisteredUserPositiveTest(){
        //oo@aa.com
        //oo@aa1.com
        //oo@aa2.com
        app.getUser().logIn();
        //Assert userLoggedIn
        Assert.assertTrue(app.getUser().isUserLoggedIn());
        String email = app.getHeader().getEmailFromHeader();
        System.out.println(email);
        Assert.assertEquals(email, "oo@aa.com");

    }

}
