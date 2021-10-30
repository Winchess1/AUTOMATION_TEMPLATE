package Configuration.utils;

import Configuration.ConfigFactory.RollingSlotsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static RollingSlotsConfig config = RollingSlotsConfig.getInstance();

    public static WebDriver getWebDriver(Browser browser){
        switch (config.getWebConfig().getBrowser()){
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                return  new ChromeDriver();
            default:
                return  new ChromeDriver();
        }
    }

    public enum Browser{
        CHROME,FIREFOX
    }
}
