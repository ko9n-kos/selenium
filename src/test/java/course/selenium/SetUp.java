package course.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class SetUp {
    public static WebDriver driver = new ChromeDriver();
    public static JavascriptExecutor js = (JavascriptExecutor) driver;
    public static SoftAssert softAssert = new SoftAssert();
    public static String getProperties(String value) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        return System.getProperty(value);
    }
    public static void system() throws IOException {
        System.setProperty("webdriver.chrome.driver", getProperties("chromedriver"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProperties("siteUrl"));
    }
}