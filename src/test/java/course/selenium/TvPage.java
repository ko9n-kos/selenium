package course.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class TvPage extends BasePage {
    public static final String tvPageUrl = "https://catalog.onliner.by/tv/";
    public static String manufacturer = "//span[contains(text(),'Производитель')]//parent::div/following-sibling::div//child::li//child::span[contains(text(), '%s')]";
    public static String price = "//div[@class='schema-filter__group']//child::input[@type='text' and contains(@placeholder, 'до')]";
    public static String diagonalFrom = "//div[@class='schema-filter__group']/child::div[1]/child::select";
    public static String diagonalTo = "//div[@class='schema-filter__group']/child::div[2]/child::select";
    public static String resolution = "//span[contains(text(),'Разрешение')]//parent::div/following-sibling::div//child::span[contains(text(),'%s')]";
    public static String productPrice = "//div[@class='schema-product__price']//child::span[contains(@data-bind, 'Price')]";
    public static String productBrand = "//div[@class='schema-product__title']//child::span[contains(@data-bind, 'name')]";
    public static String productDescription = "/div[@class='schema-product__description']//child::span[contains(@data-bind, 'description')]";
    public static String modalCity ="//div[contains(@class, 'popover-style__content')]//child::span[contains(text(), 'Да')]";
    public static void checkProductsPrice(String expected) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(productPrice))));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(productPrice))));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(productPrice)));
        List<WebElement> listOfResults = driver.findElements(By.xpath(productPrice));
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(Double.parseDouble(listOfResults.get(listOfResults.indexOf(el)).getText()
                    .replace(" р.", "").replace(',', '.')) <= Double.parseDouble(expected));
        }
    }

    public static void checkProductsBrand(String expected) {
        List<WebElement> listOfResults = driver.findElements(By.xpath(productBrand));
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public static void checkProductsDiagonal(String expectedMin, String expectedMax) {
        List<WebElement> listOfResults = driver.findElements(By.xpath(productDescription));
        for (WebElement el : listOfResults) {
            String st = listOfResults.get(listOfResults.indexOf(el)).getText().replace(",", "").trim();
            softAssert.assertTrue(Double.parseDouble(st.substring(0,1))>=Integer.parseInt(expectedMin) &&
                    Double.parseDouble(st.substring(0,1))<=Double.parseDouble(expectedMax));
        }
    }

    public static void checkProductsResolution(String expected) {
        List<WebElement> listOfResults = driver.findElements(By.xpath(productDescription));
        for (WebElement el : listOfResults) {
            softAssert.assertTrue(listOfResults.get(listOfResults.indexOf(el)).getText().contains(expected));
        }
    }

    public static void closeModal(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        js.executeScript("arguments[0].click();", element);
    }
}