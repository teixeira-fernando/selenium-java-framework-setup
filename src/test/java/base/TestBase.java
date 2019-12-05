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

public class TestBase {

    protected String browser;
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void getBrowser(String browser){
        this.browser = browser;
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + testResult.getName() + ".jpg"));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

//    @Ignore
//    public void takeScreenshotOnFailure(ITestResult testResult, WebDriver driver){
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            try{
//                Files.move(screenshot, new File("resources/screenshots/" + testResult.getName() + ".jpg"));
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }
}
