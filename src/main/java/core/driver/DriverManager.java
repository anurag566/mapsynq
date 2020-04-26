package core.driver;

import core.driver.webdrivers.ChromeDriverOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static Map<String, WebDriver> drives = new HashMap<>();

    public static WebDriver getDriver(String browserName, String version, String os, OptionsData data) {
        String key = Thread.currentThread().getName();
        if(drives.containsKey(key)) {
         return drives.get(key);
        }

        WebDriver webDriver = setDriver(getDesiredCapabilities(browserName, version, os), data);
        drives.put(key, webDriver);
        return webDriver;
    }

     public static WebDriver getDriver() {
         String key = Thread.currentThread().getName();
         if(drives.containsKey(key)) {
             return drives.get(key);
         }
         return  null;
     }


    private static DesiredCapabilities getDesiredCapabilities(String browserName, String version, String os) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(version);
        if (os.equalsIgnoreCase("mac")) {
            capabilities.setPlatform(Platform.MAC);
        } else if (os.equalsIgnoreCase("linux")) {
            capabilities.setPlatform(Platform.LINUX);
        } else if (os.equalsIgnoreCase("windows")) {
            capabilities.setPlatform(Platform.WINDOWS);
        }

        return capabilities;
    }

    private static WebDriver setDriver(DesiredCapabilities capabilities, OptionsData data) {
        ChromeOptions options = null;
        ChromeDriverOptions chromeOptions = new ChromeDriverOptions();

        if(capabilities.getBrowserName().equalsIgnoreCase("chrome")) {
            return chromeOptions.getChromeDriver(data,capabilities);
        }

        return null;
    }
}
