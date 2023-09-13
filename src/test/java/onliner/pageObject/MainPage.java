package onliner.pageObject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final String mainMenu = "//span[contains(@class,'main-navigation') and text()='%s']";
    private final By mainPagelogo = By.xpath("//div[contains(@class, 'b-top-logo')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void isMainPage(){
        verifyPage(mainPagelogo);
    }

    public void selectMainNavigationOption(String option){
        selectOption(mainMenu,option);
    }
}