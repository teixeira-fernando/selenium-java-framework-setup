package base;

import helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.*;

public class TestBase {

    protected String browser;

    @Parameters("browser")
    @BeforeSuite
    public void getBrowser(String browser){
        this.browser = browser;
    }

    @BeforeMethod
    public void SetupTest()
    {
        //driver = new DriverFactory().InitializeDriver("chrome");
    }

    @AfterTest
    public void TearDownTest()
    {
       //TODO: include configuration for screenshots
        //driver.quit();
    }
}
