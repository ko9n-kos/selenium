package onliner.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends Utils{
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyPage(By element) {
        Assert.assertTrue(waitElementToBeClickable(element).isDisplayed());
    }

    public WebElement waitElementToBeClickable(By element){
       return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
    }
    public By defineElement(String locator, String name) {
        return  By.xpath(String.format(locator, name));
    }

    public void click(By element) {
        waitElementToBeClickable(element).click();
    }

    public void selectOption(String menu, String option){
        waitElementToBeClickable(defineElement(menu, option)).click();
    }

    public void selectByText(By locator, String option){
        Select drpDown = new Select(waitElementToBeClickable(locator));
        drpDown.selectByVisibleText(option);
    }
}