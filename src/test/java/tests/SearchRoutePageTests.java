package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPageHelper;

public class SearchRoutePageTests extends TestBase{
    MainPageHelper mainPage;


    @BeforeMethod
    public void initTests(){
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @BeforeMethod
    public void insurePreconditions(){
        if(!mainPage.isAppLanguageEnglish()){
            mainPage.setAppLanguage();
        }
    }

    @Test(priority = 1, dataProvider = "usingValidCities",dataProviderClass = DataProviders.class, groups = "Functional")
    public void searchRoutePositiveTest(String cityFrom, String cityTo) {

        //fill FROM field
        mainPage.clickFromField();
        mainPage.fillFromField(cityFrom);
        driver.hideKeyboard();
        mainPage.clickFromCitiesList();

        //fill TO field
        mainPage.clickToField();
        mainPage.fillToField(cityTo);
        driver.hideKeyboard();
        mainPage.clickToCitiesList();

        //click Let's Go button
        mainPage.clickGoButton();
        //verify the route page is opened
        Assert.assertTrue(mainPage.ifRoutesPresented(), "Routes for cities: " + cityFrom + " and " + cityTo + " are not presented!");
        //click back button
        mainPage.clickBackButton();

        //click clear button
        mainPage.clickClearButton();
    }


}
