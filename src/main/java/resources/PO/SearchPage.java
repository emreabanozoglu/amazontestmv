package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;

public class SearchPage extends BasePage {
    /*
    SearchPage is a Page Object class. There is contains methods on the Amazon Search Page.
    This methods using in the test cases.
     */
    public SearchPage (WebDriver driver, WebDriverWait wait) { super(driver,wait); }

    //Page Objects
    public static final String SearchedProductTextXpath = "/html//div[@id='search']/span[@class='rush-component']/div[@class='a-section a-spacing-base s-desktop-toolbar']//span[@class='a-color-state a-text-bold']";
    public static final String firstItemClassName = "a-size-medium";

    //Page Methods
    //------------

    //Waiting Search Page is loading
    public void WaitSearchPageLoading(){
        WaitUntilPageContainsElements(SearchedProductTextXpath);
    }

    //Verifying IphoneX page tittle is correct
    public void VerifyIphoneXPageTitle(){
        VerifyPageTittleisCorrect("Amazon.com.tr: iphone x");
    }

    //Click first item in the shown page
    public void ClickFirstItemOnTheSearchPage(){
        click(By.className(firstItemClassName));
    }
}
