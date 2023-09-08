package course.selenium;

import org.testng.annotations.*;

import java.io.IOException;

import static course.selenium.CatalogPage.*;
import static course.selenium.MainPage.*;
import static course.selenium.TvPage.*;


public class OnlinerTest extends BasePage {

    @BeforeTest
    public void setup() throws IOException {
        system();
    }
    @Parameters({"brand", "priceMax","diagonalMin", "diagonalMax", "diagonalResolution"})
    @Test
    public void onlinerProductsSearchTest(String brand, String priceMax, String diagonalMin, String diagonalMax, String diagonalResolution)
    {
        MainPage.selectFromMenu(mainNavigation, "Каталог");
        CatalogPage.checkPage(catalogPageUrl);
        CatalogPage.selectFromMenu(catalogNavigationList, "Электроника");
        CatalogPage.selectFromMenu(electronicAsideList, "Телевидение");
        CatalogPage.selectFromMenu(tvAndVideoAsideList, "Телевизоры");
        TvPage.checkPage(tvPageUrl);
        TvPage.closeModal(modalCity);
        TvPage.checkCheckbox(manufacturer, brand);
        TvPage.enterValue(price, priceMax);
        TvPage.selectFromDropdown(diagonalFrom, diagonalMin);
        TvPage.selectFromDropdown(diagonalTo, diagonalMax);
        TvPage.checkCheckbox(resolution, diagonalResolution);
        TvPage.checkProductsPrice(priceMax);
        TvPage.checkProductsBrand(brand);
        TvPage.checkProductsDiagonal(diagonalMin, diagonalMax);
        TvPage.checkProductsResolution(diagonalResolution);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}