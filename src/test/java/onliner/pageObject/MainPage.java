package onliner.pageObject;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    protected final String lblMainMenu = "//span[contains(@class,'main-navigation') and text()='%s']";
    public static final By pageLocator = By.xpath("//div[contains(@class, 'b-top-logo')]");

    public MainPage(WebDriver driver) {
        super(driver, pageLocator);
    }

    public void selectMainNavigationOption(String option) {
        Label mainMenu = new Label(By.xpath(String.format(lblMainMenu, option)));
        mainMenu.click();
    }
}