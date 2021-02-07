package tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPageHelper;

public class MainPageTests extends TestBase {
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
    
    @Test(priority = 1,groups = {"UI"})
    public void sloganIsDisplayedTest(){
        Assert.assertTrue(mainPage.sloganContainsText(), "Slogan is not valid!");
    }

    @Test(priority = 1,groups = {"UI"})
    public void currencyListIsDisplayedTest() {
        mainPage.clickOnCurrencyButton();
        Assert.assertTrue(mainPage.isCurrencyListDisplayed(), "Currency list is not displayed!");
    }


    @Test(priority = 1,groups = {"UI"})
    public void languageListIsDisplayedTest(){
        mainPage.clickOnLanguageButton();
        Assert.assertTrue(mainPage.isLanguagesListDisplayed(), "Language list is not displayed!");

    }

    @Test(priority = 1,groups = {"UI"})
    public void mainMenuIsOpenedTest(){
        Assert.assertTrue(mainPage.clickOnButtonMenu(), "Main menu is not opened!");
    }


    @Test(priority = 1, groups = "Functional")
    public void contactsPageIsOpenedTest()  {
        //click Hamburger Menu
        mainPage.clickHamburgerMenu();

        //click Contacts item in menu
        mainPage.clickContactsMenuItem();

        //verify the contacts page is opened
        WebElement pageTitle = mainPage.getContactsPageTitle();
        Assert.assertEquals(pageTitle.getText(), "Contacts", "Contacts page is not opened");
    }

    @Test(priority = 1, groups = "UI")
    public void getCurrentCurrencyTest(){
        //get currency
        String currency = mainPage.getCurrentCurrency();

        //verify the currency is EUR
        Assert.assertEquals(currency, "EUR","Current currency is not EUR");
    }

    @Test(priority = 1, groups = "UI")
    public void getCurrentLanguageTest(){
        //get language
        String language = mainPage.getCurrentLanguage();

        //verify the language is En
        Assert.assertEquals(language, "En","Current language is not EN");
    }

    @Test(priority = 1, groups = "UI")
    public void setLanguageTest()  {
        String lang = "Ru";
        //open drop-down box
        mainPage.clickLanguageBox();

        //select the language
        mainPage.ClickLanguageRadioButton(lang);

        //verify the page is on correct language
        mainPage.clickFromField();
        String result = mainPage.getFromFieldTitle();

        Assert.assertEquals(result, "Откуда:","Current language is not " + lang + ".");

    }

}
