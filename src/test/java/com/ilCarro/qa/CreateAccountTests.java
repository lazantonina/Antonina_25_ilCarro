package com.ilCarro.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.getHeader().isSignUpTabPresentInHeader()){   //sign up not present
            app.getUser().logOut();
//            wd.findElement(By.xpath("//a[contains(.,'login')]")).click();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        app.getUser().openRegistrationFormFormHeader();
        Assert.assertTrue(app.getUser().isRegistrationFormOpened());
        app.getUser().fillRegistrationForm(new User()
                .withFirstName("AS")
                .withSecondName("FV")
                .withEmail("oo@aa6.com")
                .withPassword("1234567Pp"));

        app.getUser().selectPolicyCheckBox();
        pause(2000);
        //click submit button
        app.getCar().submitForm();
        //check, login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());

    }

//    @Test
//    public void testSignUpWithoutPassword() throws InterruptedException {
//        app.openRegistrationFormFormHeader();
//        Assert.assertTrue(app.isRegistrationFormOpened());
//        app.fillRegistrationForm(new User()
//                .withFirstName("Tina")
//                .withSecondName("Terner")
//                .withEmail("Tina@terner1.com"));
//
//        app.selectPolicyCheckBox();
//        pause(3000);
//
//        app.getCar().submitForm();
//
//        Assert.assertTrue(app.isLoginFormPresent());
//
//    }

    public void pause(int millis) throws InterruptedException {
        app.getCar().pause(millis);
    }

}
