package onliner.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TvPage extends BasePage {
    private final  String manufacturer = "//span[contains(text(),'Производитель')]//parent::div/following-sibling::div//child::li//child::span[contains(text(), '%s')]";
    private final  By price = By.xpath("//div[@class='schema-filter__group']//child::input[@type='text' and contains(@placeholder, 'до')]");
    private final  By diagonalFrom = By.xpath( "//div[@class='schema-filter__group']/child::div[1]/child::select");
    private final  By diagonalTo = By.xpath("//div[@class='schema-filter__group']/child::div[2]/child::select");
    private final  String resolution = "//span[contains(text(),'Разрешение')]//parent::div/following-sibling::div//child::span[contains(text(),'%s')]";
    private final  By productPrice = By.xpath("//div[@class='schema-product__price']//child::span[contains(@data-bind, 'Price')]");
    private final  By productBrand = By.xpath("//div[@class='schema-product__title']//child::span[contains(@data-bind, 'name')]");
    private final  By productDescription = By.xpath("/div[@class='schema-product__description']//child::span[contains(@data-bind, 'description')]");
    private final  By modalCity = By.xpath("//div[contains(@class, 'popover-style__content')]//child::span[contains(text(), 'Да')]");
    private final  By tvPageTitle = By.xpath("//div[@id='schema-top-button']/following-sibling::h1");

    public TvPage(WebDriver driver){
        super(driver);
    }
    public void isTvPage() {
        verifyPage(tvPageTitle);
    }

    public void selectManufacturer(String option) {
        closeModal();
        WebElement element = waitElementToBeClickable(defineElement(manufacturer, option));
        js.executeScript("arguments[0].click();", element);
        softAssert.assertTrue(element.isSelected());
    }

    public void selectResolution(String option) {
        WebElement element = waitElementToBeClickable(defineElement(resolution, option));
        element.click();
        softAssert.assertTrue(element.isSelected());
    }

    public void setMaxPrice(String value) {
        waitElementToBeClickable(price).sendKeys(value);
    }

    public void setMinDiagonal(String option) {
        selectByText(diagonalFrom,option);
    }

    public void setMaxDiagonal(String option) {
        selectByText(diagonalTo,option);
    }

    public void checkProductsPrice(String expected) {
        wait.until(ExpectedConditions.presenceOfElementLocated(productPrice));
        wait.until(ExpectedConditions.stalenessOf(waitElementToBeClickable(productPrice)));
        js.executeScript("arguments[0].scrollIntoView(true);", waitElementToBeClickable(productPrice));
        List<WebElement> listOfResults = driver.findElements(productPrice);
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(Double.parseDouble(listOfResults.get(listOfResults.indexOf(el)).getText()
                    .replace(" р.", "").replace(',', '.')) <= Double.parseDouble(expected));
        }
    }

    public void checkProductsBrand(String expected) {
        List<WebElement> listOfResults = driver.findElements(productBrand);
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void checkProductsDiagonal(String expectedMin, String expectedMax) {
        List<WebElement> listOfResults = driver.findElements(productDescription);
        for (WebElement el : listOfResults) {
            String st = listOfResults.get(listOfResults.indexOf(el)).getText().replace(",", "").trim();
            softAssert.assertTrue(Double.parseDouble(st.substring(0,1))>=Integer.parseInt(expectedMin) &&
                    Double.parseDouble(st.substring(0,1))<=Double.parseDouble(expectedMax));
        }
    }

    public void checkProductsResolution(String expected) {
        List<WebElement> listOfResults = driver.findElements(productDescription);
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public void closeModal(){
        click(modalCity);
    }
}