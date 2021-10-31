package Configuration.utils;

import Configuration.ConfigFactory.SystemConfig;
import Configuration.ConfigFactory.WebConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static final long DRIVER_WAIT_TIME = 10;
    private static final long DRIVER_SCRIPT_WAIT_TIME = 10;

    private static Configuration.ConfigFactory.WebConfig WebConfig = new WebConfig();
    private static SystemConfig config = SystemConfig.getInstance();
    public static WebDriver getDriver() {
        if (DriverManager.getWebDriver() == null) {
            startDriver();
        }
        return DriverManager.getWebDriver();
    }

    public static void quitDriver() {
        DriverManager.quitWebDriver();
    }

    public static void startDriver() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        setDriverDefaults(driver);
        DriverManager.setWebDriver(driver);


//        WebDriver driver = WebDriverFactory.getWebDriver();
//        setDriverDefaults(driver);
//        DriverManager.setWebDriver(driver);
    }

    private static void setDriverDefaults(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DRIVER_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DRIVER_SCRIPT_WAIT_TIME, TimeUnit.SECONDS);
//        driver.manage().window().setPosition(new Point(0, 0));
    }

    public static void runDriverFromEnvTest (){

        getDriver().get(config.getWebConfig().getBaseUrl());
    }
}
