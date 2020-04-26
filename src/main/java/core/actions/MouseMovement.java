package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
    private WebDriver driver = null;

    public MouseMovement() {
        this.driver = DriverManager.getDriver();
    }

    public void hoverElement(WebElement element){
        try{
            Actions actions = new Actions(this.driver);
            actions.moveToElement(element).build().perform();
        }catch (Exception e) {

        }
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        try{
            Actions actions = new Actions(this.driver);
            actions.dragAndDrop(source,target).build().perform();
        }catch (Exception e) {

        }
    }

    public void dragAndDrop2(WebElement from, WebElement to) {
        try {
            Actions actions = new Actions(this.driver);
            actions.clickAndHold(from).moveToElement(to).release(from).build().perform();
        }catch (Exception e) {

        }
    }
}
