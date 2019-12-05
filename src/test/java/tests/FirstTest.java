package tests;

import base.TestBase;
import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class FirstTest extends TestBase{

    @Test
    public void test1(){
        WebDriver driver = new DriverFactory().InitializeDriver(this.browser);
        driver.get("https://www.google.com");
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = new DriverFactory().InitializeDriver(this.browser);
        driver.get("https://www.globo.com");
        driver.quit();
    }


}
