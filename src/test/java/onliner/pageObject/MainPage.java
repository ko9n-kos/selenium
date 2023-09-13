package onliner.pageObject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final String mainMenu = "//span[contains(@class,'main-navigation') and text()='%s']";
    public static final By pageLocator = By.xpath("//div[contains(@class, 'b-top-logo')]");

    public MainPage(WebDriver driver) {
        super(driver, pageLocator);
    }

    public void selectMainNavigationOption(String option) {
        selectOption(driver.findElement(By.xpath(String.format(mainMenu, option))));
    }
}