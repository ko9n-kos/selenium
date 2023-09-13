package onliner.pageObject;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {
    private final String catalogNavigationList = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    private final String electronicAsideList = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    private final String tvAndVideoAsideList = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";
    private final By catalogPageTitle = By.xpath("//div[@class='catalog-navigation__title' and contains(text(), 'Каталог')]");
    public CatalogPage(WebDriver driver){
        super(driver);
    }
    public void isCatalogPage() {
        verifyPage(catalogPageTitle);
    }

    public void selectCatalogListOption(String option){
        selectOption(catalogNavigationList, option);
    }

    public void selectElectronicOption(String option){
        selectOption(electronicAsideList, option);
    }

    public void selectTvAndVideoOption(String option){
       selectOption(tvAndVideoAsideList, option);
    }
}