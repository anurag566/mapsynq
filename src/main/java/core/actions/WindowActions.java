package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowActions {
    private WebDriver driver = null;

    public WindowActions() {
        this.driver = DriverManager.getDriver();
    }

    public String get(String url) {
        String title = null;
        try {
            this.driver.get(url);
            title = this.driver.getTitle();
        }catch (Exception e) {
            System.out.println("Error while opening the url."+e);
        }
        return title;
    }

    public String getTitle() {
        try {
            return this.driver.getTitle();
        }catch (Exception e) {
            System.out.println("Error while getting the tile. "+e);
        }
        return null;
    }

    public String switchToWindow(String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for(String window : windowHandles) {
            if (driver.switchTo().window(window).getTitle().equalsIgnoreCase(title)) {
                return window;
            }
        }
        return null;
    }

    public void maximizeWindow(){
        this.driver.manage().window().maximize();
    }

    public void scrollIntoView(WebElement element) {
        try {
            JavascriptExecutor jexecutor = (JavascriptExecutor)this.driver;
            jexecutor.executeScript("arguments[0].scrollIntoView()", element);
        }catch (Exception e) {
            System.out.println("Error while scroll in to view : "+e);
        }
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }

    public void navigateForward() {
        this.driver.navigate().forward();
    }

    public void refresh() {
        this.driver.navigate().refresh();
    }

/* ------------------------ Frame -------------------------------- */
    public void switchToFrameByNameOrId(String nameOrId) {
        this.driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByIndex(int index) {
        this.driver.switchTo().frame(index);
    }

    public void switchToFrameByElement(WebElement element) {
        this.driver.switchTo().frame(element);
    }

    public void frameToDefaultPage() {
        this.driver.switchTo().defaultContent();
    }

    public void switchToParentFrame() {
        this.driver.switchTo().parentFrame();
    }

    /* ------------------------ Frame End -------------------------------- */

    /* ------------------------ Alert -------------------------------- */
    public void acceptAlert() {
        try {
            this.driver.switchTo().alert().accept();
        }catch (Exception e) {

        }
    }

    public void dismisAlert() {
        try {
            this.driver.switchTo().alert().dismiss();
        }catch (Exception e) {

        }
    }

    public String getAlertText() {
        String text = null;
        try {
            text = this.driver.switchTo().alert().getText();
        }catch (Exception e) {

        }
        return text;
    }

    public void inputOnAlert(String value) {
        this.driver.switchTo().alert().sendKeys(value);
    }
    /* ------------------------ Alert End -------------------------------- */
}
