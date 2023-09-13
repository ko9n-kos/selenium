package onliner.pageObject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {

    private final String catalogNavigationList = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    private final String electronicAsideList = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    private final String tvAndVideoAsideList = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";
    public static final By pageLocator = By.xpath("//div[@class='catalog-navigation__title' and contains(text(), 'Каталог')]");

    public CatalogPage(WebDriver driver) {
        super(driver, pageLocator);
    }

    public void selectCatalogListOption(String option) {
        selectOption(driver.findElement(By.xpath(String.format(catalogNavigationList, option))));
    }

    public void selectElectronicOption(String option) {
        selectOption(driver.findElement(By.xpath(String.format(electronicAsideList, option.replace("и ", "и ")))));
    }

    public void selectTvAndVideoOption(String option) {
        selectOption(driver.findElement(By.xpath(String.format(tvAndVideoAsideList, option))));
    }
}