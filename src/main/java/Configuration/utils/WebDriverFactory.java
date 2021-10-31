package Configuration.utils;

import Configuration.ConfigFactory.SystemConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static SystemConfig config = SystemConfig.getInstance();

    public static WebDriver getWebDriver(){
        switch (config.getWebConfig().getBrowser()){
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case CHROME:{
                WebDriverManager.chromedriver().setup();
                return  new ChromeDriver();
            }

            default:
                return  new ChromeDriver();
        }
    }

    public enum Browser{
        CHROME,FIREFOX
    }

}
