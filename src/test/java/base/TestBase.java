package base;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import helpers.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {

    protected WebDriver driver;
    protected Logger logger = null;

    @BeforeSuite
    public void beforeSuite(){
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", System.getProperty("browser"))
                        .put("BaseUrl", "http://google.com")
                        .put("RemoteExecution", System.getProperty("remoteExecution"))
                        .build());
    }

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
            saveScreenshotInBytes();
            Allure.addAttachment("Error Log message", testResult.getThrowable().getMessage());
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

    @Attachment(value = "Error Page Screenshot", type = "image/png")
    private byte[] saveScreenshotInBytes(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
