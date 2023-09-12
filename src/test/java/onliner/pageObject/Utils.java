package onliner.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Utils {
    protected static WebDriver driver = new ChromeDriver();
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;
    protected static SoftAssert softAssert = new SoftAssert();
    protected static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static void getDriver(){
        WebDriverManager.chromedriver().setup();
    }

    public static void setUp() throws IOException {
        getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProperties("siteUrl"));
    }

    public static void tearDown(){
        driver.quit();
    }

    public static String getProperties(String value) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        return System.getProperty(value);
    }
}