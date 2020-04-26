package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TextActions {

    public String getText(WebElement element) {
        try {
            return element.getText();
        }catch (Exception e) {
            System.out.println("Error While getting the text : "+e);
        }
        return null;
    }

    public String getInnerHtml(WebElement element) {
        try{
            JavascriptExecutor executor = (JavascriptExecutor)(DriverManager.getDriver());
            return executor.executeScript("arguments[0].innerHTML",element).toString();
        }catch (Exception e) {
            System.out.println("Error while fetching innerHTML of object : "+e);
        }
        return null;
    }

    public String getValue(WebElement element) {
        try{
            JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
            return executor.executeScript("return arguments[0].value",element).toString();
        }catch (Exception e) {
            System.out.println("Error while fetching value of object "+e);
        }
        return null;
    }
}
