package tests;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.*;

@Feature("First Test")
public class FirstTest extends TestBase{

    @BeforeClass
    public void setup(){
        super.setup();
        Allure.suite("Test 1");
    }

    @Test
    @Description("First Test - Test 1")
    public void test1() {
        driver.get("https://www.google.com");
        driver.findElement(By.id("abc"));
    }

    @Test
    @Description("First Test - Test 2")
    public void test2(){
        driver.get("https://www.globo.com");
    }


}
