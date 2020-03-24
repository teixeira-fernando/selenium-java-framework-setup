package tests;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.GoogleHomePage;

@Feature("First Test")
public class FirstTest extends TestBase{

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
