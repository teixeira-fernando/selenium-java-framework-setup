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
    private String browser = System.getProperty("browser");
    private boolean remoteExecution = Boolean.valueOf(System.getProperty("remoteExecution"));
    private String serverURL = "http://localhost:4444/wd/hub";
    private String baseURL = "http://google.com/";

    public WebDriver InitializeDriver() {
        if(remoteExecution == true) {
            try {
                DesiredCapabilities capabilities = null;
                if (browser.toLowerCase().equals("chrome")) {
                    capabilities = DesiredCapabilities.chrome();
                } else if (browser.toLowerCase().equals("firefox")) {
                    capabilities = DesiredCapabilities.firefox();
                }
                driver = new RemoteWebDriver(new URL(serverURL), capabilities);
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }
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
        driver.get(baseURL);
        return driver;
    }
}


