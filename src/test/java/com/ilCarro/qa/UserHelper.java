package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public void logOut() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
        

    }

    protected void logIn() {
        click(By.cssSelector("[href='/login"));
       fillLoginForm(new User().withEmail("oo@aa.com").withPassword("1234567Pp"));
       submitForm();
    }

    public void selectPolicyCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void openRegistrationFormFormHeader() {
        click(By.cssSelector("[href='/signup']"));
    }

    public boolean isRegistrationFormOpened() {
        return isElementPresent(By.cssSelector("form.signup__fields"));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        fillLoginForm(user);
    }

    public boolean isFindCarFormPresent(){
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

    }

    public boolean isFindCarFormPresent2(){
        return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }

    public void openAddCarFormHeader() {
       click(By.cssSelector(".header__nav [href='/car']"));
    }

    public void toFillCarForms(Car car) {
       type(By.cssSelector(".country"), car.getCountry());
       type(By.cssSelector(".address"), car.getAddress());
       type(By.cssSelector(".distance_included"), car.getDistance());
       type(By.cssSelector(".serial_number"), car.getSerialNumber());
       type(By.cssSelector(".brand"), car.getBrand());
       type(By.cssSelector(".model"), car.getModel());
       type(By.cssSelector(".year"), car.getYear());
       type(By.cssSelector(".engine"), car.getEngine());
       type(By.cssSelector(".fuel_consumption"), car.getFuelConsumption());
       type(By.cssSelector(".fuel"), car.getFuel());
       type(By.cssSelector(".transmition"), car.getTransmition());
       type(By.cssSelector(".wd"), car.getWd());
       type(By.cssSelector(".horsepower"), car.getHorsepower());
       type(By.cssSelector(".torque"), car.getTorque());
       type(By.cssSelector(".doors"), car.getDoors());
       type(By.cssSelector(".seats"), car.getSeats());
       type(By.cssSelector(".class"), car.getAutoClass());
       type(By.name("about"), car.getAbout());
       type(By.cssSelector(".type_feature"), car.getFeature());
       type(By.cssSelector(".price"), car.getPrice());
    }
}
