package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InputActions {

    public void input(WebElement element, String value) {
        try {
            element.sendKeys(value);
        }catch (Exception e) {

        }
    }

    public void jscriptInput(WebElement element, String value) {
        try{
            JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
            executor.executeScript("arguments[0].value="+value, element);
        }catch (Exception e) {

        }
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public void inputByKeyPress(WebElement element,String value) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.sendKeys(element, value).build().perform();
        }catch (Exception e) {

        }
    }

    public void clearByBackSpace(WebElement element, int numBackSpace) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            for(int i = 0; i < numBackSpace; i++) {
                actions.sendKeys(element, Keys.BACK_SPACE).build().perform();
            }

        }catch (Exception e) {
            System.out.println("Error while pressing backspace : "+e);
        }
    }
}
