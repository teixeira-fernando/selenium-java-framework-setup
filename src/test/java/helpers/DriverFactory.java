package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver InitializeDriver(String browser){
        if (browser.toLowerCase().equals("chrome")){
            if(System.getProperty("os.name").contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            }
            else{
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            }
            driver = new ChromeDriver();
        }
        else if (browser.toLowerCase().equals("firefox")){
            if(System.getProperty("os.name").contains("Windows")) {
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            }
            else{
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
            }
            driver = new FirefoxDriver();
        }
        return driver;
    }
}


