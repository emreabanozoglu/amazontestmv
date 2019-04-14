package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import tests.BaseTest;
import java.io.File;

public class Screenshot extends TestListenerAdapter {
    /*
    This class is an TestNG listener class. In this class contains capture a screenshot methods on the any test failure.
     */
    String Seperator=System.getProperty("file.separator");

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        Reporter.setCurrentTestResult(result);
        String sTestClassName=result.getTestClass().getRealClass().getSimpleName();
        System.out.println("Test class name ..."+sTestClassName);
        String sFileName=result.getName();
        System.out.println("Test method name ..."+sFileName);
        driver= BaseTest.gerDriverDetails(result.getTestClass().getName());
        String imagePathInHost="../screenshots"+Seperator+"LatestResults"+Seperator+sTestClassName+Seperator+captureScreenshot(driver,sTestClassName,sFileName);
        System.out.println("Image path...."+imagePathInHost);
        Reporter.log("<a href=" + imagePathInHost + "> <img width='750px' src=" + imagePathInHost + "> </a>");
        Reporter.setCurrentTestResult(null);

    }

    public String captureScreenshot(WebDriver driver,String sTestClassName,String sFileName)
    {
        sFileName=sFileName+".jpg";
        try
        {
            File file = new File("screenshots" + Seperator + "LatestResults");
            if (!file.exists())
            {
                System.out.println("File created somewhere" + file);
                file.mkdir();
            }

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName, sFileName);
            FileUtils.copyFile(sourceFile, targetFile);
            return sFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
