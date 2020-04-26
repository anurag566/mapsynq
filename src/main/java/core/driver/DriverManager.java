package core.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static Map<String, WebDriver> drives = new HashMap<>();

    public static WebDriver getDriver(String browserName, String version, String os) {
        if(drives.containsKey(browserName)) {
         return drives.get(browserName);
        }
        WebDriver webDriver = setDriver(getDesiredCapabilities(browserName, version, os));
        drives.put(browserName, webDriver);
        return webDriver;
    }

    public static WebDriver getDriver() {
        return getDriver("chrome","79","MAC");
    }

    private static DesiredCapabilities getDesiredCapabilities(String browserName, String version, String os) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(version);
        capabilities.setPlatform(Platform.MAC);
        return capabilities;
    }

    private static WebDriver setDriver(Capabilities capabilities) {
        if(capabilities.getBrowserName().equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/anuragsharma/Downloads/chromedriver");
            return new ChromeDriver(capabilities);
        }
        return null;
    }
}
