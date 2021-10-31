package rollingslots.ui.mainPage;

import RollingSlots.UI.MainPage.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Configuration.utils.DriverFactory.runDriverFromEnvTest;
import static Configuration.utils.Waiter.waitUntilLandingPageIsLoaded;

public class MainPageTest {
    private final MainPage mainpage = new MainPage();
    @Test
    @DisplayName("Проверка элементов на странице")
    void contextLoads() {
        runDriverFromEnvTest();
        waitUntilLandingPageIsLoaded();
        mainpage.LogoDisplay();
        mainpage.SidebarDisplay();


    }
}
