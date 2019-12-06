package base;

import com.google.common.io.Files;
import helpers.DriverFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class TestBase {

    protected WebDriver driver;
    protected Logger logger = null;


    @BeforeClass
    public void setup()  {
        PropertyConfigurator.configure("config/log4j.properties");
        logger = Logger.getLogger(this.getClass());
        driver =  new DriverFactory().InitializeDriver();
        logger.info("The driver has been initialized");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
        logger.info("The driver was closed");
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            logger.debug("The test '"+ testResult.getName() + "' has failed  and the driver logs has been saved for analysis");
            logger.error(testResult.getThrowable().getMessage());
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + testResult.getName() + " " +new Timestamp(System.currentTimeMillis())+".jpg"));
                logger.error("Screenshot was saved!");
            }
            catch (IOException e){
                logger.error("Error in the screenshot capture process");
                e.printStackTrace();
            }
        }
    }
}
