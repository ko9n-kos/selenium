package course.selenium;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class BasePage extends SetUp {
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static WebElement getElement(String locator, String name) {
       return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(locator, name)))));
    }

    public static void checkPage(String expected) {
        softAssert.assertEquals(driver.getCurrentUrl(), expected);
    }

    public static void selectFromMenu(String locator, String name) {
        getElement(locator, name).click();
    }

    public static void checkCheckbox(String locator, String name) {
        WebElement element = getElement(locator, name);
        js.executeScript("arguments[0].click();", element);
        softAssert.assertTrue(element.isSelected());
    }

    public static void enterValue(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public static void selectFromDropdown(String locator, String value) {
        Select drpDiagonal = new Select(driver.findElement(By.xpath(locator)));
        drpDiagonal.selectByVisibleText(value);
    }
}