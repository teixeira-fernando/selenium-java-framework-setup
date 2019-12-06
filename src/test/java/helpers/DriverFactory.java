package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private WebDriver driver;
    private String browser = System.getProperty("browser");
    private boolean remoteExecution = Boolean.valueOf(System.getProperty("remoteExecution"));
    private String serverURL = "http://localhost:4444/wd/hub";
    private String baseURL = "http://google.com/";
    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions firefoxOptions = new FirefoxOptions();


    public WebDriver InitializeDriver() {
        if(remoteExecution == true) {
            try {
                if (browser.toLowerCase().equals("chrome")) {
                    driver = new RemoteWebDriver(new URL(serverURL), chromeOptions);
                } else if (browser.toLowerCase().equals("firefox")) {
                    driver = new RemoteWebDriver(new URL(serverURL), firefoxOptions);
                }
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

                driver = new ChromeDriver(chromeOptions);
            } else if (browser.toLowerCase().equals("firefox")) {
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                }
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
        return driver;
    }
}