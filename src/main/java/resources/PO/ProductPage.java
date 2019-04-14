package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import resources.BasePage;
import java.util.List;

public class ProductPage extends BasePage {
    /*
    ProductPage is a Page Object class. There is contains methods on the Amazon Product Page.
    This methods using in the test cases.
     */
    public ProductPage(WebDriver driver, WebDriverWait wait) { super(driver,wait); }

    //Page Objects
    public static final String BackTheResultsXpath = "//*[@id=\"breadcrumb-back-link\"]"; //    //*[@id="breadcrumb-back-link"]
    public static final String OtherPrice1AddToBasketID="mbc-buybutton-addtocart-1-announce";
    public static final String OtherPrice2AddToBasketID="mbc-buybutton-addtocart-2-announce";
    List<WebElement> prices = driver.findElements(By.className("a-size-medium"));

    //Page Methods
    //------------

    //Waiting product page is loading
    public void waitProductPageLoading(){
        WaitUntilPageContainsElements(BackTheResultsXpath);
    }

    //Comparing price from amazon other sellers and clicking lowest one
    public void comparePriceAddToBasketLowestPriceProduct(){
        String strPrice1 = prices.get(2).getText();
        String strPrice2 = prices.get(3).getText();

        StringBuilder str1 = new StringBuilder(strPrice1);
        StringBuilder str2 = new StringBuilder(strPrice2);

        str1.delete(5, 11);
        str2.delete(5, 11);

        double price1 = Double.parseDouble(String.valueOf(str1));
        double price2 = Double.parseDouble(String.valueOf(str2));

        Reporter.log("First product price = " + price1);
        Reporter.log("Second second price =" + price2);

        if(price1<price2){
            Reporter.log("First product have a lowest price");
            click(By.id(OtherPrice1AddToBasketID));
        }else{
            click(By.id(OtherPrice2AddToBasketID));
            Reporter.log("Second product have a lowest price");
        }
    }
}
