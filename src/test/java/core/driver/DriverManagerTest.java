package core.driver;

import core.actions.WindowActions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DriverManagerTest {
    @Before
    public void setUpDriver() {
        OptionsData data = new OptionsData();
        data.setDriverPath("/Users/anuragsharma/Downloads/chromedriver");
        data.setAddArguments("--headless");
        WebDriver driver = DriverManager.getDriver("chrome", "81", "mac",data);
    }

    @Test
    public void testDriverSetUp() {
        WindowActions win = new WindowActions();
        win.get("https://www.google.com/");
        String title = win.getTitle();
        System.out.println("Title is : "+title);
        Assert.assertEquals("Google",title);
    }

    @After
    public void killDriver() {
        DriverManager.getDriver().quit();
    }
}
