package base;

import com.google.common.io.Files;
import helpers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setup()  {
        driver =  new DriverFactory().InitializeDriver();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + testResult.getName() + " " +new Timestamp(System.currentTimeMillis())+".jpg"));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
