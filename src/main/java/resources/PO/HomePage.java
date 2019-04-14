package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.BasePage;

public class HomePage extends BasePage {
    /*
    HomePage is a Page Object class. There is contains methods on the Amazon Home Page.
    This methods using in the test cases.
     */
    public HomePage(WebDriver driver, WebDriverWait wait) { super(driver,wait); }

    //Page Objects

    public static final String baseURL = "https://www.amazon.com.tr/";
    public static final String searchBoxID = "twotabsearchtextbox";
    public static final String firstSuggestionID= "issDiv0";



    //Page Methods
    //------------

    //Go to base URL using baseURL variable
    public void goTo (){
        driver.get(baseURL);
    }

    //Verifying HomePage Loaded with get current url
    public void verifyHomePageLoaded (){
        Assert.assertEquals(baseURL,driver.getCurrentUrl());
    }

    //Search an item in homepage search box
    public void searchItem(String item) throws InterruptedException {
        writeText(By.id(searchBoxID),item);
        Thread.sleep(1000);
    }

    //Clicking IphoneX from suggestions
    public void clickiPhoneXSuggestion(){
        click(By.id(firstSuggestionID));
    }
}
