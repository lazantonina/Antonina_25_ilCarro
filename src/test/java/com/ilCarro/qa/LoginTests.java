package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        //oo@aa1.com
        //oo@aa2.com
        fillLoginForm(new User().withEmail("oo@aa.com").withPassword("1234567Pp"));

        submitForm();
        //Assert userLoggedIn
        Assert.assertTrue(isUserLoggedIn());
        String email = wd.findElement(By.cssSelector("[href='/account']")).getText();
        System.out.println(email);
        Assert.assertEquals(email, "oo@aa.com");

    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());

    }
}
