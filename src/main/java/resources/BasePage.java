package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    /*
    BasePage contains all selenium side methods.
    This methods using in the Page Object Classes.
     */

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Click on the element using by element location (id, xpath, classname etc..)
    public void click(By elementLocation) { driver.findElement(elementLocation).click();
    }

    //Write text in the element using by element location (id, xpath, classname etc..)
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Wait contains element in the page. This method use xpath locators.
    public void WaitUntilPageContainsElements(String elementName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
    }

    //Verify page tittle is correct or not. Here use assert library for equals.
    public void VerifyPageTittleisCorrect(String expectedTittle){
        Assert.assertEquals(driver.getTitle(),expectedTittle);
    }
}
