package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends BaseTest {

    protected WebDriver driver;

    public BasePage(WebDriver driver, By element) {
        this.driver = driver;
        Assert.assertTrue(waitElementToBeClickable(element).isDisplayed());
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public WebElement waitElementToBeClickable(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(findElement(element)));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By element) {
        waitElementToBeClickable(element).click();
    }

    public void selectOption(WebElement element) {
        waitElementToBeClickable(element).click();
    }

    public void selectByText(By locator, String option) {
        Select drpDown = new Select(waitElementToBeClickable(locator));
        drpDown.selectByVisibleText(option);
    }

    public void verifyValueIsSelected(WebElement element){
        softAssert.assertTrue(element.isSelected());
    }
}