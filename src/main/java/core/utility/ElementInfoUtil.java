package core.utility;

import core.element.ElementInfo;
import org.openqa.selenium.WebElement;

public class ElementInfoUtil {
    public ElementInfo getInfo(String info) {
        return createInfo(info);
    }

    public ElementInfo getInfo(String info, WebElement element) {
        ElementInfo eInfo = createInfo(info);
        eInfo.setElement(element);
        return eInfo;
    }

    private ElementInfo createInfo(String info) {
        ElementInfo elInfo = new ElementInfo();

        String[] infoArr = info.split("@@");
        if(infoArr.length < 4) {
            return null;
        }

        elInfo.setLocator(infoArr[0]);
        elInfo.setValue(infoArr[1]);
        elInfo.setVisibility(infoArr[2]);
        elInfo.setTimeout(new Long(infoArr[3]));
        return elInfo;
    }
}
