package onliner.stepsDefinition;

import framework.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObject.CatalogPage;
import onliner.pageObject.MainPage;
import onliner.pageObject.TvPage;

import java.io.IOException;

public class Steps extends BaseTest {
    MainPage mainPage = new MainPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);
    TvPage tvPage = new TvPage(driver);

    @Before
    public static void setUp() throws IOException {
        BaseTest.setUp();
    }
    @After
    public static void tearDown(){
        BaseTest.finish();
    }

    @Given("^I'm not signed in user on the main page and navigate to the Catalogue page$")
    public void navigateToCatalogPage() {
        mainPage.checkPageIsCorrect();
        mainPage.selectMainNavigationOption("Каталог");
    }

    @When("^I click on the catalog menu option 'Электроника', electronic aside list 'Телевидение и видео' and select 'Телевизоры'$")
    public void navigateToTvsPage() {
        catalogPage.checkPageIsCorrect();
        catalogPage.selectCatalogListOption("Электроника");
        catalogPage.selectElectronicOption("Телевидение и видео");
        catalogPage.selectTvAndVideoOption("Телевизоры");
    }

    @And("^I select manufacturer as (.*)$")
    public void selectBrand(String brand) {
        tvPage.checkPageIsCorrect();
        tvPage.selectManufacturer(brand);
    }

    @And("^I set max price as (.*)$")
    public void setMaxPrice(String priceMax) {
        tvPage.setMaxPrice(priceMax);
    }

    @And("^I set min (.*) diagonal$")
    public void setMinDiagonal(String diagonalMin) {
        tvPage.setMinDiagonal(diagonalMin);
    }

    @And("^I set max (.*) diagonal$")
    public void setMaxDiagonal(String diagonalMax) {
        tvPage.setMaxDiagonal(diagonalMax);
    }

    @And("^I select screen resolution as (.*)$")
    public void selectDiagonalResolution(String diagonalResolution) {
        tvPage.selectResolution(diagonalResolution);
    }

    @Then("^I see the list of products that match by (.*), (.*), (.*) and (.*) diagonal, (.*)$")
    public void verifySearchResults(String priceMax, String brand, String diagonalMin, String diagonalMax, String diagonalResolution) {
        tvPage.checkProductsPrice(priceMax);
        tvPage.checkProductsBrand(brand);
        tvPage.checkProductsDiagonal(diagonalMin, diagonalMax);
        tvPage.checkProductsResolution(diagonalResolution);
    }
}