package tests;

import base.TestBase;
import helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class FirstTest extends TestBase{

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver =  new DriverFactory().InitializeDriver(this.browser);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        //driver = new DriverFactory().InitializeDriver(this.browser);
        //WebDriver driver = new DriverFactory().InitializeDriver(this.browser);
        driver.get("https://www.google.com");
        driver.findElement(By.id("abc"));
        /*if (Reporter.getCurrentTestResult().getStatus()== ITestResult.FAILURE){
            takeScreenshotOnFailure(Reporter.getCurrentTestResult(), driver);
        }*/
    }

    @Test
    public void test2(){

        //driver = new DriverFactory().InitializeDriver(this.browser);
        driver.get("https://www.globo.com");
       /* if (Reporter.getCurrentTestResult().getStatus()== ITestResult.FAILURE){
            takeScreenshotOnFailure(Reporter.getCurrentTestResult(), driver);
        }*/
    }


}
