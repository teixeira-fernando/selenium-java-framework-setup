package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    public Page goTo(String postUrl) {
        webDriver.get(postUrl);
        return new Page(webDriver);
    }
}
