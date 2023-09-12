package onliner.pageObject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;

public class BaseTest extends Utils {
    protected MainPage mainPage = new MainPage(driver);
    protected CatalogPage catalogPage = new CatalogPage(driver);
    protected TvPage tvPage = new TvPage(driver);
    @BeforeTest
    public void start() throws IOException { setUp(); }
    @AfterTest
    public void finish() { tearDown(); }
}