package onliner.pageObject;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TvPage extends BasePage {
    private static final String checkboxManufacturer = "//span[contains(text(),'Производитель')]//parent::div/following-sibling::div//child::li//child::span[contains(text(), '%s')]";
    private static final By txtboxPrice = By.xpath("//div[@class='schema-filter__group']//child::input[@type='text' and contains(@placeholder, 'до')]");
    private static final By drpDownDiagonalFrom = By.xpath("//div[@class='schema-filter__group']/child::div[1]/child::select");
    private static final By drpDownDiagonalTo = By.xpath("//div[@class='schema-filter__group']/child::div[2]/child::select");
    private static final String checkboxResolution = "//span[contains(text(),'Разрешение')]//parent::div/following-sibling::div//child::span[contains(text(),'%s')]";
    private static final By lblProductPrice = By.xpath("//div[@class='schema-product__price']//child::span[contains(@data-bind, 'Price')]");
    private static final By lblProductBrand = By.xpath("//div[@class='schema-product__title']//child::span[contains(@data-bind, 'name')]");
    private static final By lblProductDescription = By.xpath("/div[@class='schema-product__description']//child::span[contains(@data-bind, 'description')]");
    private static final By btnModalCity = By.xpath("//div[contains(@class, 'popover-style__content')]//child::span[contains(text(), 'Да')]");
    private static final By lblProduct = By.xpath("//div[@id = 'schema-products']//child::div[@class='schema-product__group']");
    public static final By pageLocator = By.xpath("//div[@id='schema-top-button']/following-sibling::h1");

    public TvPage(WebDriver driver) {
        super(driver, pageLocator);
    }

    public void selectManufacturer(String option) {
        closeModal();
        Checkbox manufacturer = new Checkbox(By.xpath(String.format(checkboxManufacturer, option)));
        manufacturer.clickViaJs();
        manufacturer.verifyValueIsSelected();
    }

    public void selectResolution(String option) {
        Checkbox resolution = new Checkbox(By.xpath(String.format(checkboxResolution, option)));
        resolution.click();
        resolution.verifyValueIsSelected();
    }

    public void setMaxPrice(String value) {
        TextBox price = new TextBox(txtboxPrice);
        price.enterValue(value);
    }

    public void setMinDiagonal(String option) {
        DropDown minDiagonal = new DropDown(drpDownDiagonalFrom);
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", minDiagonal.findElement());
        minDiagonal.selectFromDrpDown(option);
    }

    public void setMaxDiagonal(String option) {
        DropDown maxDiagonal = new DropDown(drpDownDiagonalTo);
        maxDiagonal.selectFromDrpDown(option);
    }

    public void checkProductsPrice(String expected) {
        Label product = new Label(lblProduct);
        product.checkStalenessOfElement();
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'});", product.findElement());
        List<WebElement> listOfResults = product.findElements(lblProductPrice);
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(Double.parseDouble(listOfResults.get(listOfResults.indexOf(el)).getText()
                    .replace(" р.", "").replace(',', '.')) <= Double.parseDouble(expected));
        }
    }

    public void checkProductsBrand(String expected) {
        Label productBrand = new Label(lblProductBrand);
        List<WebElement> listOfResults = productBrand.findElements();
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void checkProductsDiagonal(String expectedMin, String expectedMax) {
        Label productDescription = new Label(lblProductDescription);
        List<WebElement> listOfResults = productDescription.findElements();
        for (WebElement el : listOfResults) {
            String st = listOfResults.get(listOfResults.indexOf(el)).getText().replace(",", "").trim();
            softAssert.assertTrue(Double.parseDouble(st.substring(0, 1)) >= Integer.parseInt(expectedMin) &&
                    Double.parseDouble(st.substring(0, 1)) <= Double.parseDouble(expectedMax));
        }
    }

    public void checkProductsResolution(String expected) {
        Label productDescription = new Label(lblProductDescription);
        List<WebElement> listOfResults = productDescription.findElements();
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void closeModal() {
        Button modalCity = new Button(btnModalCity);
        modalCity.click();
    }
}