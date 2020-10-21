package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public String getEmailFromHeader() {
        return wd.findElement(By.cssSelector("[href='/account']")).getText();
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
