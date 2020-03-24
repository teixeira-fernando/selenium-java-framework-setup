package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends Page{

    By searchBar = By.className("gLFyf");
    By searchButton = By.className("gNO89b");

    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void performASearch(String searchTerm){
        this.wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        webDriver.findElement(searchBar).sendKeys(searchTerm);
        webDriver.findElement(searchBar).sendKeys(Keys.ENTER);
    }
}
