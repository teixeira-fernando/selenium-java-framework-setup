package tests;

import base.TestBase;
import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest extends TestBase {

    @Test
    public void test1(){
        WebDriver driver = new DriverFactory().InitializeDriver("chrome");
        driver.get("https://www.google.com");
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = new DriverFactory().InitializeDriver("firefox");
        driver.get("https://www.globo.com");
        driver.quit();
    }


}
