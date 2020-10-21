package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCarFormsTests extends TestBase {


   @Test
    public void letTheCarWorkTest() throws InterruptedException {
      if(!app.getUser().isUserLoggedIn()){
         app.getUser().logIn();
      }
       //click on Let the cat work button
      app.getCar().openAddCarFormHeader();
      Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//h3[contains(.,'Let the car work')]")));

      app.getCar().toFillCarForms(new Car()
              .setCountry("Israel")
              .setAddress("Netanya")
              .setDistance("1000")
              .setSerialNumber("123-45-678")
              .setBrand("BMW").setModel("X1")
              .setYear("2015").setEngine("2.0")
              .setFuelConsumption("10")
              .setFuel("diesel")
              .setTransmition("AT")
              .setWd("4WD")
              .setHorsepower("193")
              .setTorque("280")
              .setDoors("5")
              .setSeats("5")
              .setAutoClass("A")
              .setAbout("color marrakesh")
              .setFeature("with wifi")
              .setPrice("250"));
      app.getCar().pause(3000);
      app.getCar().submitForm();

   }

   @Test
   public void negativeTestAddCarWithoutDoors() throws InterruptedException {
      app.getCar().openAddCarFormHeader();
      Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//h3[contains(.,'Let the car work')]")));

      app.getCar().toFillCarForms(new Car()
              .setCountry("Israel")
              .setAddress("Netanya")
              .setDistance("1000")
              .setSerialNumber("123-45-679")
              .setBrand("BMW").setModel("X1")
              .setYear("2015").setEngine("2.0")
              .setFuelConsumption("10")
              .setFuel("diesel")
              .setTransmition("AT")
              .setWd("4WD")
              .setHorsepower("193")
              .setTorque("280")
              .setSeats("5")
              .setAutoClass("A")
              .setAbout("color marrakesh")
              .setFeature("with wifi")
              .setPrice("250"));
      app.getCar().pause(3000);
      app.getCar().submitForm();

   }

}
