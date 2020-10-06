package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FillCarForms extends TestBase {

   @Test
    public void letTheCarWorkTest(){
       //click on Let the cat work button
       click(By.cssSelector("[href='/car']"));
       Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(.,'Let the car work')]")));

       //fill the fields Location
       type(By.cssSelector(".country"), "Israel");
       type(By.cssSelector(".address"), "Netanya");
       type(By.cssSelector(".distance_included"), "1000");

       //fill the fields Car details
       type(By.cssSelector(".serial_number"), "123-45-67");
       type(By.cssSelector(".brand"), "BMW");
       type(By.cssSelector(".model"), "X1");
       type(By.cssSelector(".year"), "2015");
       type(By.cssSelector(".engine"), "2.0");
       type(By.cssSelector(".fuel_consumption"), "10");
       type(By.cssSelector(".fuel"), "diesel");
       type(By.cssSelector(".transmition"), "AT");
       type(By.cssSelector(".wd"), "4WD");
       type(By.cssSelector(".horsepower"), "193");
       type(By.cssSelector(".torque"), "280");
       type(By.cssSelector(".doors"), "5");
       type(By.cssSelector(".seats"), "5");
       type(By.cssSelector(".class"), "A");

       //fill the fields About
       type(By.cssSelector("placeholder='About (max 500 chars)'"), "the color is marrakesh");
       type(By.cssSelector(".type_feature"), "with wifi");
       type(By.cssSelector(".price"), "250");

       submitForm();

   }
}
