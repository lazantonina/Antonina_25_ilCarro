package com.ilCarro.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By by){
        try{
            wd.findElement(by);
            return true;
        } catch(NoSuchElementException ex){
            return false;
        }

    }

    public void type(By locator, String text) {
        if(text != null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);

        }

    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void submitForm() throws InterruptedException {
        Thread.sleep(2000);
        wd.findElement(By.cssSelector("[type='submit']")).click();

    }

}
