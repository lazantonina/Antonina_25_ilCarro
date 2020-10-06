package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignUpTabPresentInHeader()){   //sign up not present
            logOut();
//            wd.findElement(By.xpath("//a[contains(.,'login')]")).click();
        }
    }

    @Test
    public void testSignUp(){
        //click on SignUp button
        //wd.findElement(By.cssSelector("[href='/signup']")).click();
        click(By.cssSelector("[href='/signup']"));

        //fill registration form
        type(By.cssSelector("#first_name"), "AS");
        type(By.cssSelector("#second_name"), "FV");
        type(By.cssSelector("#email"), "oo@aa2.com");
        type(By.cssSelector("#password"), "1234567Pp");


//        wd.findElement(By.cssSelector("#second_name")).click();
//        wd.findElement(By.cssSelector("#second_name")).clear();
//        wd.findElement(By.cssSelector("#second_name")).sendKeys("FV");

//        wd.findElement(By.cssSelector("#email")).click();
//        wd.findElement(By.cssSelector("#email")).clear();
//        wd.findElement(By.cssSelector("#email")).sendKeys("oo@aa.com");

//        wd.findElement(By.cssSelector("#password")).click();
//        wd.findElement(By.cssSelector("#password")).clear();
//        wd.findElement(By.cssSelector("#password")).sendKeys("1234567Pp");

        //wd.findElement(By.cssSelector("#check_policy")).click();
        click(By.cssSelector("#check_policy"));

        //click submit button

        submitForm();


        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());

    }


}
