package com.ilCarro.qa.tests;

import com.ilCarro.qa.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){

        app.init();
        // login("oo@aa7.co", "1234568Pp");

    }

    @BeforeMethod
    public void startTest(Method m, Object[] p){

        logger.info("Start test " + m.getName() + "  with data: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: Test method " + result.getMethod().getMethodName());
        } else{
            logger.error("FAILED: Test method " + result.getMethod().getMethodName());
            logger.info("Screenshot: " + app.session().takeScreenshot());
        }

        logger.info("Stop test ");
        logger.info("=====================================================");
    }

    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }

}

