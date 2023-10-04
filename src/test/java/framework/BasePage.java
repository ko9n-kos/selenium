package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage extends BaseTest {

    protected WebDriver driver;
    protected By pageTitle;

    public BasePage(WebDriver driver, By pageTitle) {
        this.driver = driver;
        this.pageTitle = pageTitle;

    }

    public void checkPageIsCorrect() {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pageTitle))).isDisplayed());
    }
}