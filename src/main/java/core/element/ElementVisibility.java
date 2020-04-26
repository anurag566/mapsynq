package core.element;

import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ElementVisibility {
    private WebDriver driver = null;
    private ElementBy elementBy = null;

    public ElementVisibility() {
        driver = DriverManager.getDriver();
        elementBy = new ElementBy();
    }

    public WebElement getElement(ElementInfo info) {
        By by = elementBy.getBy(info);
        WebDriverWait wait = new WebDriverWait(driver, info.getTimeout());
        return element(by, info.getVisibility(), wait, info);
    }

    public List<WebElement> getElements(ElementInfo info) {
        By by = elementBy.getBy(info);
        WebDriverWait wait = new WebDriverWait(driver, info.getTimeout());
        return elements(by,info.getVisibility(), wait, info);
    }

    private WebElement element(By by, String visibility, WebDriverWait wait, ElementInfo info) {
        switch(visibility.toLowerCase()) {
            case "elementtobeclickable":
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case "presenceofelement":
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case "visibilityofelementlocated":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case "presenceofnestedelementlocatedby" :
                return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(info.getElement(),by));
            default :
                return null;
        }
    }

    private List<WebElement> elements(By by, String visibility, WebDriverWait wait, ElementInfo info) {
        switch(visibility.toLowerCase()) {
            case "visibilityofallelements":
                return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            default:
                return null;
        }
    }

}
