package core.element;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Elements {
    private ElementVisibility visibility = null;

    public Elements() {
        visibility = new ElementVisibility();
    }
    public WebElement findElement(ElementInfo info) {
        return visibility.getElement(info);
    }

    public List<WebElement> findElements(ElementInfo info) {
        return visibility.getElements(info);
    }
}
