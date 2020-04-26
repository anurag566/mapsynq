package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBordActions {
    private WebDriver driver = null;

    public KeyBordActions(){
        this.driver = DriverManager.getDriver();
    }

    public void ctrlA(WebElement element){
        try {
            String keys = Keys.chord(Keys.CONTROL,"a");
            element.sendKeys(keys);
        }catch (Exception e) {
            System.out.println("Error while pressing control a ");
        }
    }

    public void ctrlAbyActions(WebElement element){
        try {
            Actions actions = new Actions(this.driver);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        }catch (Exception e) {
            System.out.println("Error while performing ctrl + a by actions");
        }
    }
}
