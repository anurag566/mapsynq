package core.driver.webdrivers;

import core.driver.OptionsArguments;
import core.driver.OptionsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.InvocationTargetException;

public class ChromeDriverOptions {

    public ChromeOptions getOptions(OptionsData optionsData, DesiredCapabilities capabilities) {
        ChromeOptions options =null;
        try {
            options =  new OptionsArguments().getOptionWithArguments(ChromeOptions.class,optionsData.getAddArguments());
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        options.merge(capabilities);
        System.setProperty("webdriver.chrome.driver", optionsData.getDriverPath());
        if(optionsData.getBinary() != null) {
            options.setBinary(optionsData.getBinary());
        }
        return options;
    }

    public WebDriver getChromeDriver(OptionsData optionsData, DesiredCapabilities capabilities) {
        return new ChromeDriver(getOptions(optionsData, capabilities));
    }
}
