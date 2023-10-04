package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getProperties;

public class BaseTest {

    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public static SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public static void setUp() throws IOException {
        driver = BrowserFactory.browserSetUp();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getProperties("config.properties", "timeOut"))));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperties("config.properties", "timeOut")), TimeUnit.SECONDS);
        driver.get(getProperties("config.properties", "siteUrl"));
    }

    @AfterTest
    public static void finish() {
        driver.quit();
    }
}