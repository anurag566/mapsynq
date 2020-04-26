package core.element;

import org.openqa.selenium.By;

public class ElementBy {

    public By getBy(ElementInfo info) {
        String value = info.getValue();
        switch(info.getLocator().toLowerCase()) {
            case "id" :
                return By.id(value);
            case "name" :
                return By.name(value);
            case "css" :
                return By.cssSelector(value);
            case "xpath" :
                return By.xpath(value);
            case "class" :
                return By.className(value);
            default :
                return null;

        }
    }
}
