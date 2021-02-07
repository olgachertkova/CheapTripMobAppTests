package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.PageBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public AppiumDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage","io.ionic.starter");
        capabilities.setCapability("appActivity","io.ionic.starter.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

 
  
    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p){
        logger.info("Start test: " + m.getName());
        if(p.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(p));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quit(ITestResult result) throws IOException {
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            logger.info("Screenshot: " + PageBase.takeScreenShot(driver));

        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }

}
