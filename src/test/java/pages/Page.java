package pages;

import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver webDriver;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Page goTo(String postUrl) {
        webDriver.get(postUrl);
        return new Page(webDriver);
    }
}
