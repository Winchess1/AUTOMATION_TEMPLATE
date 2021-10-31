package RollingSlots.UI.MainPage;

import RollingSlots.BasePage.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {
    @FindBy(how = How.CLASS_NAME, using = "header__logo")
    public WebElement HeaderLogo;
    @FindBy(how = How.CLASS_NAME, using = "popup__bg")
    public WebElement SideBar;

    @Step("Проверка если лого отображается")
    public void LogoDisplay() {
        assertEquals("block",HeaderLogo.getCssValue("display"));
    }
    @Step("Проверка если лого отобржается sidebar")
    public void SidebarDisplay() {
        assertEquals(true,SideBar.isDisplayed());
    }
}
