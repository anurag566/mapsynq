package core.actions;

import org.openqa.selenium.WebElement;

public class ElementActions {

    public String getAttribute(WebElement element, String attribute) {
        try {
            return element.getAttribute(attribute);
        }catch (Exception e) {
            System.out.println("Error while fetching the attribute");
        }
        return null;
    }

    public String getCssValue(WebElement element, String cssValue) {
        try{
            return element.getCssValue(cssValue);
        }catch (Exception e) {
            System.out.println("Error while fetching the css value."+e);
        }
        return null;
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean idDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
}
