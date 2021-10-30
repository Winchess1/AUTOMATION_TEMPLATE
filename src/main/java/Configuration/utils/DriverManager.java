package Configuration.utils;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>() {
        @SneakyThrows
        @Override
        public void remove() {
            WebDriver driver = get();
            if (driver != null) {
                driver.quit();
            }
            super.remove();
        }
    };

    protected static WebDriver getWebDriver() {
        return webDriver.get();
    }

    protected static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    protected static void quitWebDriver() {
        webDriver.get().quit();
        webDriver.get().close();
        webDriver.set(null);
        webDriver.remove();
    }
}
