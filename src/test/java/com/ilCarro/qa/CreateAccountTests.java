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
    public void testSignUp() throws InterruptedException {
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillRegistrationForm(new User()
                .withFirstName("AS")
                .withSecondName("FV")
                .withEmail("oo@aa4.com")
                .withPassword("1234567Pp"));

        click(By.cssSelector("#check_policy"));
        pause(2000);
        //click submit button
        submitForm();
        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());

    }

    @Test
    public void testSignUpWithoutPassword() throws InterruptedException {
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillRegistrationForm(new User()
                .withFirstName("Tina")
                .withSecondName("Terner")
                .withEmail("Tina@terner1.com"));

        click(By.cssSelector("#check_policy"));
        pause(3000);
        //click submit button
        submitForm();
        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());

    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
