package com.ilCarro.qa.tests;

import com.ilCarro.qa.model.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() throws InterruptedException {

        if (!app.session().isUserLoggedIn()) {
            app.session().login("oo@aa7.co", "1234568Pp");
        }

    }


   @Test
   public void testFormLetTheCarWork() throws InterruptedException {
       //app.header().click(By.cssSelector(".let-carwork-style_let_car__location__30BIh"));
       //app.header().click(By.cssSelector("[href='/car']"));
       app.header().addCar();

       //".header__nav [href='/car']"



       app.car().fillAddCarForm(new Car()
              .setCountry("Israel")
              .setAddress("Netanya")
              .setDistance("1000")
              .setSerialNumber("115-45-678")
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
      app.car().submitForm();

   }
}
