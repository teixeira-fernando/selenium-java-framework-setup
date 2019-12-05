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

    @Test
    public void test1() {
        driver.get("https://www.google.com");
    }

    @Test
    public void test2(){
        driver.get("https://www.globo.com");
    }


}
