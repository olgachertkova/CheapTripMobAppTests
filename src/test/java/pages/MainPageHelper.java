package pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHelper extends PageBase {
    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view." +
            "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android." +
            "view.View[1]/android.view.View/android.view.View/android.view.View/android.view." +
            "View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android." +
            "view.View[2]/android.view.View[2]")
    WebElement slogan;


    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
        "webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android." +
        "view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view." +
        "View/android.view.View[2]/android.view.View[2]\n")
    WebElement homeMenu;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
            "webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android." +
            "view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view." +
            "View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.RadioButton/android.widget.Button")
    WebElement buttonRu;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
            "webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android." +
            "view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view." +
            "View/android.view.View[1]/android.view.View[2]/android.view.View[2]")
    WebElement sloganContainsRuText;

    @FindBy(className = "android.widget.Button")
    WebElement menuButton;
    @FindBy(className = "android.view.View")
    WebElement currencyDropDownList;


    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.view.ViewGroup" +
            "/android.webkit.WebView/android.webkit.WebView/android.view.View" +
            "/android.view.View/android.view.View[2]/android.view.View[3]" +
            "/android.view.View/android.view.View")
    WebElement languagesDropDownList;

    public boolean sloganContainsText() {
        waitUntilAllElementsVisible(slogan, 2);
        return slogan.getText().contains("CheapTrip.Pay less, travel more");
    }

    public void clickOnCurrencyButton() {
        driver.findElement(By.className("android.widget.ListView")).click();
    }

    public boolean isCurrencyListDisplayed() {
        waitUntilElementVisible(currencyDropDownList, 10);
        return currencyDropDownList.isDisplayed();
    }


    public boolean clickOnButtonMenu() {
        menuButton.click();
        return homeMenu.isDisplayed();

    }

    public void selectLanguageRu() {
        buttonRu.click();
    }

    public boolean languageChanged() {
        return sloganContainsRuText.getText().contains("CheapTrip.Плати меньше, посети больше");
    }

    public void clickOnLanguageButton() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.view.ViewGroup/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View" +
                "/android.view.View/android.view.View/android.view.View" +
                "/android.view.View/android.view.View/android.view.View" +
                "/android.view.View/android.view.View[2]/android.view.View[2]" +
                "/android.view.View[2]/android.view.View/android.view.View[1]" +
                "/android.view.View[2]")).click();
    }

    public boolean isLanguagesListDisplayed() {
        waitUntilElementVisible(languagesDropDownList, 10);
        return languagesDropDownList.isDisplayed();

    }

    public void clickHamburgerMenu() {
        clickElement(By.xpath("//android.widget.Button[@text ='menu']"));
    }

    public void clickContactsMenuItem() {
        clickElement(By.xpath("//android.view.View[@text ='Contacts']"));
    }

    public void clickHomeMenuButton() {
        clickElement(By.xpath("//android.view.View[@text ='home']"));
    }

    public void clickFromField() {
        clickElement(By.xpath("//*[@resource-id='ion-input-0-lbl']"));
    }

    public void fillFromField(String cityFrom) {
        fillField(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]//" +
                "android.view.View[1]//android.view.View[1]//android.view.View[1]//android.view.View[1]//" +
                "android.view.View//android.view.View[2]//android.widget.EditText"), cityFrom);
    }

    public void clickFromCitiesList() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/" +
                "android.view.View[2]/" +
                "android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[1]/" +
                "android.view.View/android.view.View/android.view.View/android.widget.Button"));
    }

    public void clickToCitiesList() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/" +
                "android.view.View[2]/android.view.View[2]/" +
                "android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button"));
    }

    public void fillToField(String cityTo) {
        fillField(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]//" +
                "android.view.View[2]//android.view.View[1]//android.view.View[1]//android.view.View[1]//" +
                "android.view.View//android.view.View[2]//android.widget.EditText"), cityTo);
    }

    public void clickToField() {
        clickElement(By.xpath("//*[@resource-id='ion-input-1-lbl']"));
    }

    public void clickGoButton() {
        clickElement(By.xpath("//android.view.View[@content-desc=\"LET'S GO\"]/android.view.View"));
    }

    public void clickClearButton() {
        clickElement(By.xpath("//android.widget.Button[@text ='CLEAR']"));
    }

    public void clickBackButton() {
        clickElement(By.xpath("//android.widget.Button[@text ='back']"));
    }

    public boolean ifRoutesPresented() {
        return ifElementExists(By.xpath("//android.widget.Button[contains(@resource-id,'mat-expansion-panel-header-')]"));
    }

    public WebElement getContactsPageTitle() {
        return findElementOnPage(By.xpath("//android.view.View[@text ='Contacts']"));
    }

    public String getCurrentCurrency() {
        return findElementOnPage(By.xpath("//android.view.View[1]//android.view.View//android.view.View//android.view.View[1]" +
                "//android.view.View//android.widget.ListView//android.view.View[1]")).getText();
    }

    public String getCurrentLanguage() {
/*        return findElementOnPage(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]")).getText();*/
        return getText(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));
    }

    public String getFromFieldTitle() {
/*        String result = findElementOnPage(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]" +
                "//android.view.View[1]//android.view.View//android.view.View[1]//android.view.View[1]//android.view.View" +
                "//android.view.View[1]")).getText();
        return result;*/
        return getText(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]" +
                "//android.view.View[1]//android.view.View//android.view.View[1]//android.view.View[1]//android.view.View" +
                "//android.view.View[1]"));
    }

    public void ClickLanguageRadioButton(String lang) {
        clickElement(By.xpath("//android.view.View[@text = '" + lang + "']"));
    }

    public void clickLanguageBox() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));
    }

    public boolean isAppLanguageEnglish() {
        /*String lang = findElementOnPage(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]")).getText();*/
        String lang = getText(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));

        if(lang.equals("En")){
            return true;
        }
        return false;
    }

    public void setAppLanguage(){
        //open drop-down box
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));

        //select the language
        clickElement(By.xpath("//android.view.View[@text = 'En']"));
    }

    public void clickOnLetsGoButton() {
       clickGoButton();
    }

    public void fillTOField(String cityTo) {
        clickToField();
        fillToField(cityTo);
        clickToCitiesList();
    }

    public void fillFROMField(String cityFrom) {
        clickFromField();
        fillFromField(cityFrom);
        clickFromCitiesList();
    }

}
