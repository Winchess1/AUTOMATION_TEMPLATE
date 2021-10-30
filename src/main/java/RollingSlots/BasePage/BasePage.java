package RollingSlots.BasePage;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import static Configuration.utils.DriverFactory.getDriver;


public class BasePage {
    private static final String BASE_URL = "";

    protected WebDriver driver;
    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());
    }


}
