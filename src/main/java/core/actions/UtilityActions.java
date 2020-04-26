package core.actions;

import core.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UtilityActions {
    private WebDriver driver = null;

    public UtilityActions() {
        this.driver = DriverManager.getDriver();
    }

    public void takeScreenShot(String path) throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Move Image file to destination
        File file = new File(path);
        FileUtils.copyFile(srcFile, file);
    }
}
