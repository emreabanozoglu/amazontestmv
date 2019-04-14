package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;

public class BaseTest {
    /*
    BaseTest is contains Before and After classes. This classes running before and after test suite.
     */
    private static HashMap<String, WebDriver> driverObjMap=new HashMap<String, WebDriver>();

    public WebDriver driver;
    public WebDriverWait wait;

    //Test setup and starting browser
    @Parameters("Browser")
    @BeforeClass
    public void setUp(String Browser) {

        if(Browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            Reporter.log("Chrome Browser is opened");
            wait=new WebDriverWait(driver,3);
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser is maximized");
        }else if(Browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
            Reporter.log("Firefox Browser is opened");
            wait=new WebDriverWait(driver,3);
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser is maximized");
        }

        driverObjMap.put(getClass().getName(),driver);

    }

    public static WebDriver gerDriverDetails(String className){
        return driverObjMap.get(className);
    }

    public static HashMap<String, WebDriver> gerDriverObjMap(){
        return driverObjMap;
    }

    //Finish all tests on the MainTest after running this methods and close the browser.
    @AfterClass
    public void tearDown() throws InterruptedException {
        if(gerDriverObjMap().get(getClass().getName())!=null){
            gerDriverObjMap().get(getClass().getName()).quit();
            gerDriverObjMap().remove(getClass().getName());
            System.out.println("driver for class : "+ getClass().getName() + "is closed");
        }
        Thread.sleep(1000);
        driver.quit();
        Reporter.log("Browser is closed");

    }
}
