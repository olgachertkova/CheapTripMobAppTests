package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class PageBase {

  protected WebDriver driver;

  public PageBase(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public static String takeScreenShot(WebDriver webdriver) throws IOException {
    //Convert web driver object to TakeScreenshot
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);

    //Call getScreenshotAs method to create image file
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    //Create new file name
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());
    String curDate = formatter.format(date);
    String filePath = "screenshots/screenshot_" + curDate +".png";

    //Move image file to new destination
    File DestFile=new File(filePath);

    //Copy file at destination
    FileUtils.copyFile(SrcFile, DestFile);
    return filePath;

  }

  void waitUntilElementVisible (WebElement element, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e){
      e.printStackTrace();
    }
  }



  void waitUntilAllElementsVisible (WebElement element, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(element));
    } catch (Exception e){
      e.printStackTrace();
    }
  }



  public void swipeUp() {
    AppiumDriver appDriver = (AppiumDriver)(driver);
    TouchAction action = new TouchAction(appDriver);
    Dimension size = driver.manage().window().getSize();
    int starty = (int) (size.height * 0.8);
    int endy = (int) (size.height * 0.20);
    int startx = (int) (size.width * 0.5);
    action.press(PointOption.point(startx,starty))
            .waitAction()
            .moveTo(PointOption.point(startx,endy))
            .release()
            .perform();

  }

  public WebElement findElementOnPage(By locator){
    return driver.findElement(locator);
  }

  public boolean ifElementExists(By locator){
    return driver.findElements(locator).size() > 0;
  }

  public void clickElement(By locator){
    findElementOnPage(locator).click();
  }

  public void fillField(By locator, String cityName) {
    findElementOnPage(locator).clear();
    findElementOnPage(locator).sendKeys(cityName);
  }

  public String getText(By locator) {
    return findElementOnPage(locator).getText();
  }


}
