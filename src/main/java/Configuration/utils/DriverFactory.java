package Configuration.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;

public class DriverFactory {

    public static final long DRIVER_WAIT_TIME = 10;
    private static final long DRIVER_SCRIPT_WAIT_TIME = 10;

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
    }

    private static void setDriverDefaults(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DRIVER_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DRIVER_SCRIPT_WAIT_TIME, TimeUnit.SECONDS);
//        driver.manage().window().setPosition(new Point(0, 0));
    }
}
