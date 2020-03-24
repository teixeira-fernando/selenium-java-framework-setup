package tests;

import base.TestBase;
import helpers.DriverFactory;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.GoogleHomePage;

public class SecondTest extends TestBase{

    GoogleHomePage homePage;

    @BeforeClass
    public void setup()  {
        super.setup();
        homePage = new GoogleHomePage(driver);
    }

    @Test
    @Description("First Test - Test 1")
    public void test1() {
        homePage.performASearch("Automated Test");
    }


}
