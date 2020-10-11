package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCarForms extends TestBase {

   @Test
    public void letTheCarWorkTest() throws InterruptedException {
       //click on Let the cat work button
       click(By.cssSelector("[href='/car']"));
       Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Let the car work')]")));

      toFillCarForms(new Car()
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
      pause(3000);
      submitForm();

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

   public void pause(int millis) throws InterruptedException {
      Thread.sleep(millis);
   }
}
