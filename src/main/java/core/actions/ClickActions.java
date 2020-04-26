package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActions {

    public void click(WebElement element) {
        try{
            element.click();
        }catch (Exception e) {
            System.out.println("Exception while click on the element : "+e);
        }
    }

    public void doubleClick(WebElement element) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).doubleClick(element).build().perform();
        }catch (Exception e) {
            System.out.println("Exception while double click on the element : "+e);
        }
    }

    public void actionClick(WebElement element) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).click(element).build().perform();
        }catch (Exception e) {
            System.out.println("Exception while click on the element : "+e);
        }
    }

    public void rightClick(WebElement element) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.contextClick(element).perform();
        }catch (Exception e) {
            System.out.println("Exception while right click on the element : "+e);
        }
    }

    public void jscriptClick(WebElement element) {
        try {
            JavascriptExecutor jscript = (JavascriptExecutor)DriverManager.getDriver();
            jscript.executeScript("arguments[0].click()",element);
        }catch (Exception e) {
            System.out.println("Exception while javascript click on the element : "+e);
        }
    }
}
