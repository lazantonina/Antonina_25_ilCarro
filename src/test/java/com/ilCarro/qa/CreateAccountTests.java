package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){   //sign up not present
            wd.findElement(By.xpath("//a[contains(., 'logOut')]")).click();  //click on Logout button
//            wd.findElement(By.xpath("//a[contains(.,'login')]")).click();
        }
    }

    @Test
    public void testSignUp(){
        //click on SignUp button
        wd.findElement(By.cssSelector("[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

        //fill registration form
        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("AS");

        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("FV");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("oo@aa.com");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("1234567Pp");

        wd.findElement(By.cssSelector("#check_policy")).click();


    }





    //click Submit button
    //check, login form displayed
}
