package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getProperties;

public class BaseTest {

    protected static WebDriver driver = new ChromeDriver();
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;
    protected static SoftAssert softAssert = new SoftAssert();
    protected static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void getDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUp() throws IOException {
        getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProperties("siteUrl"));
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }
}