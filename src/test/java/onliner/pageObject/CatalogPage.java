package onliner.pageObject;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {

    private static final String lblCatalogNavigationList = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    private static final String lblElectronicAsideList = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    private static final String lblTvAndVideoAsideList = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";
    public static final By pageLocator = By.xpath("//div[@class='catalog-navigation__title' and contains(text(), 'Каталог')]");

    public CatalogPage(WebDriver driver) {
        super(driver, pageLocator);
    }

    public void selectCatalogListOption(String option) {
        Label catalogNavigationList = new Label(By.xpath(String.format(lblCatalogNavigationList, option)));
        catalogNavigationList.click();
    }

    public String nbspReplacement(String option) {
        if (option.contains("и ")) {
            return option.replace("и ", "и ");
        }
        return option;
    }

    public void selectElectronicOption(String option) {
        Label electronicAsideList = new Label(By.xpath(String.format(lblElectronicAsideList, nbspReplacement(option))));
        electronicAsideList.click();
    }

    public void selectTvAndVideoOption(String option) {
        Label tvAndVideoAsideList = new Label(By.xpath(String.format(lblTvAndVideoAsideList, option)));
        tvAndVideoAsideList.click();
    }
}