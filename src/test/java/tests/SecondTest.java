package tests;

import base.TestBase;
import helpers.DriverFactory;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest extends TestBase{

    @Test
    public void test1() {
        driver.get("https://www.google.com");
    }

    @Test
    public void test12(){
        driver.get("https://www.globo.com");
    }


}
