package helpers;

import com.sun.jndi.toolkit.url.Uri;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver InitializeDriver(String browser) throws MalformedURLException {
        if(Boolean.valueOf(System.getProperty("remoteExecution")) == true) {
            DesiredCapabilities capabilities = null;
            if(browser.toLowerCase().equals("chrome")){
                capabilities = DesiredCapabilities.chrome();
            } else if (browser.toLowerCase().equals("firefox")) {
                capabilities = DesiredCapabilities.firefox();
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        else {
            if (browser.toLowerCase().equals("chrome")) {
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                }
                driver = new ChromeDriver();
            } else if (browser.toLowerCase().equals("firefox")) {
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                }
                driver = new FirefoxDriver();
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}


