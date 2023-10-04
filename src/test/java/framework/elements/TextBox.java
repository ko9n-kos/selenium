package framework.elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By elementLocator) {
        super(elementLocator);
    }

    public void enterValue(String value) {
        driver.findElement(element).sendKeys(value);
    }
}