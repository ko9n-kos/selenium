package onliner.test;

import onliner.pageObject.*;
import org.testng.annotations.*;

public class OnlinerTest extends BaseTest {

    @Parameters({"brand", "priceMax","diagonalMin", "diagonalMax", "diagonalResolution"})
    @Test
    public void onlinerProductsSearchTest(String brand, String priceMax, String diagonalMin, String diagonalMax, String diagonalResolution)
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.isMainPage();
        mainPage.selectMainNavigationOption("Каталог");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.isCatalogPage();
        catalogPage.selectCatalogListOption("Электроника");
        catalogPage.selectElectronicOption("Телевидение");
        catalogPage.selectTvAndVideoOption("Телевизоры");
        TvPage tvPage = new TvPage(driver);
        tvPage.isTvPage();
        tvPage.selectManufacturer(brand);
        tvPage.setMaxPrice(priceMax);
        tvPage.setMinDiagonal(diagonalMin);
        tvPage.setMaxDiagonal(diagonalMax);
        tvPage.selectResolution(diagonalResolution);
        tvPage.checkProductsPrice(priceMax);
        tvPage.checkProductsBrand(brand);
        tvPage.checkProductsDiagonal(diagonalMin, diagonalMax);
        tvPage.checkProductsResolution(diagonalResolution);
    }
}