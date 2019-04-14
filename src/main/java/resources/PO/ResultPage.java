package resources.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;

public class ResultPage extends BasePage {
    /*
    ResultsPage is a Page Object class. There is contains methods on the adding any item in the basket and its showing this Amazon Results Page.
    This methods using in the test cases.
     */
    public ResultPage(WebDriver driver, WebDriverWait wait) { super(driver,wait); }

    //Page Objects
    public static final String addedBasketXpath = "//*[@id=\"huc-v2-order-row-confirm-text\"]/h1";

    //Page Methods
    //------------

    //Waiting result page is loading
    public void waitResultPageLoading(){
        WaitUntilPageContainsElements(addedBasketXpath);
    }

    //Verifying result page tittle is correct
    public void VerifyResultPageTittleIsCorrect(){
        VerifyPageTittleisCorrect("Amazon.com.tr Alışveriş Sepeti");
    }
}
