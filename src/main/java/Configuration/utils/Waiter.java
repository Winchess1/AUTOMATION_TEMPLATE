package Configuration.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

import static Configuration.utils.DriverFactory.getDriver;

public class Waiter {

    private static final Wait<WebDriver> wait = new FluentWait<>(getDriver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(NoSuchElementException.class);

    public static void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitTextIsNot(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    public static void waitTextIs(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    public static void clearAndSend(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        element.sendKeys(text);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//    public static Boolean waitUntilElementImageDisplayed(WebElement element) {
//        Boolean p = (Boolean) ((JavascriptExecutor)WebDriverFactory.getWebDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", element);
//        return p;
//    }

    public static void waitUntilLandingPageIsLoaded() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bg")));
    }

    public static void waitUntilElementIsVisible(By by) {

        wait.until(driver -> driver.findElement(by));
    }

    public static void waitForJStoLoad() {
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString()
                .equals("complete");
        wait.until(jsLoad);
    }

    public static void waitForNumberOfWindowsToEqual(final int numberOfWindows) {
        wait.until((ExpectedCondition<Boolean>) driver ->
                (Objects.requireNonNull(driver).getWindowHandles().size() == numberOfWindows));
    }

}

