package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        //go to login page
        if(!isLoginFormPresent()){

            if(isUserLoggedIn()){
                logOut();
            }
            clickLoginTabOnHeader();
        }

    }

    @Test
    public void loginRegisteredUserPositiveTest(){
        //oo@aa.com
        //fill login form
        type(By.name("email"), "oo@aa.com");
        type(By.name("password"), "1234567Pp");

        //submit login
        submitForm();

        //Assert userLoggedIn

    }
}
