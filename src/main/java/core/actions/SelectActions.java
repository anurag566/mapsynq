package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectActions {
    private WebDriver driver = null;

    public SelectActions() {
        this.driver = DriverManager.getDriver();
    }

    public void selectByVisibleText(WebElement selectElement, String visibleText) {
        try{
            Select select = new Select(selectElement);
            select.selectByVisibleText(visibleText);
        }catch (Exception e) {

        }
    }

    public void selectByValue(WebElement selectElement, String value) {
        try{
            Select select = new Select(selectElement);
            select.selectByValue(value);
        }catch (Exception e) {

        }
    }

    public void selectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        }catch (Exception e) {

        }
    }

    public boolean isMultiSelect(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    public List<WebElement> getAllOptions(WebElement selectElement) {
        Select select = new Select(selectElement);
        return select.getOptions();
    }

    public List<WebElement> getAllSelectedOptions(WebElement selectElement) {
        Select select = new Select(selectElement);
        return select.getAllSelectedOptions();
    }

    public WebElement getFirstSelectedOptions(WebElement selectElement) {
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption();
    }

    public void deselectByVisibleText(WebElement selectElement, String visibleText) {
        Select select = new Select(selectElement);
        select.deselectByVisibleText(visibleText);
    }

    public void deselectAll(WebElement selectElement) {
        Select select = new Select(selectElement);
        select.deselectAll();
    }

    public void deselectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
    }

    public void deslelectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }
}
