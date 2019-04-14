package tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.PO.HomePage;
import resources.PO.ProductPage;
import resources.PO.ResultPage;
import resources.PO.SearchPage;

public class MainTest extends BaseTest{
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private ResultPage resultPage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        resultPage = new ResultPage(driver, wait);
    }

    //Go to the url “www.amazon.com.tr”
    @Test(priority = 0, description = "GoToAmazonWebPage")
    public void GoToAmazonAndVerify() {
        homePage.goTo();
        Reporter.log("Browser is opened");
        homePage.verifyHomePageLoaded();
        Reporter.log("Verified Home Page Load");
    }

    //Write “iPhone” into the search field. Click the “iPhone X” on the suggestion popup.
    @Test(priority = 1)
    public void SearchIPhoneAndClickIPhoneX() throws InterruptedException {
        homePage.searchItem("iPhone");
        Reporter.log("iPhone searched");
        Thread.sleep(1000);
        homePage.clickiPhoneXSuggestion();
        Reporter.log("Clicked iPhoneX suggesstion");
    }

    //Select the first “iPhone X” product on the shown page.
    @Test(priority=2)
    public void ClickFirstItemInTheSearchPage(){
        searchPage.WaitSearchPageLoading();
        searchPage.VerifyIphoneXPageTitle();
        Reporter.log("Verified iPhoneX Product Page Shown");
        searchPage.ClickFirstItemOnTheSearchPage();
        Reporter.log("Clicked first product in the page");
    }

    //Check the price of the second item at the “Amazon'daki Diğer Satıcılar” section which is shown at the right panel.
    //Compare the prices of them and put the lowest one to the basket
    @Test(priority = 3)
    public void CompareThePriceAndAddToBasketLowestPriceProduct(){
        productPage.waitProductPageLoading();
        productPage.comparePriceAddToBasketLowestPriceProduct();
        Reporter.log("Compered the other sellers price and added to basket lower price product");
    }

    //Verifying adding to basket is successfully.
    @Test(priority = 4)
    public void VerifyAddingToBasketIsSuccess(){
        resultPage.waitResultPageLoading();
        resultPage.VerifyResultPageTittleIsCorrect();
        Reporter.log("Verified product adding to basket");
    }
}
