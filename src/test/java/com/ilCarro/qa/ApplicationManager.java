package com.ilCarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;
    CarHelper car;
    HeaderHelper header;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public CarHelper getCar() {
        return car;
    }
}
