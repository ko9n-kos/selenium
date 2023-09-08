package course.selenium;

public class CatalogPage extends BasePage {
    public static final String catalogPageUrl = "https://catalog.onliner.by/";
    public static String catalogNavigationList = "//li[@data-id='12']/following-sibling::li//child::span[contains(text(), '%s')]";
    public static String electronicAsideList = "//div[@data-id='1']//child::div[contains(text(), '%s')]";
    public static String tvAndVideoAsideList = "//div[@data-id='1']//child::div//child::span[contains(text(), '%s')]";
}