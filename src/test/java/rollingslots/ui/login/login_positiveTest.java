package rollingslots.ui.login;

import RollingSlots.UI.Login.login_positive;
//import main.java.RollingSlots.UI.Login.login_positive;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;

import static Configuration.utils.DriverFactory.getDriver;
import static Configuration.utils.Waiter.waitUntilLandingPageIsLoaded;

@Tag("login")
public class login_positiveTest  {

    private final login_positive login_positive = new login_positive();
//    @BeforeAll
//    public static void beforeAll(){
//        System.out.println("fart");
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"Glad","Dad","sit"})
//    public void testing(String role){
//        System.out.println(role);
//    }

    @Test
    @DisplayName("Check if user can login")
    void contextLoads() {
        getDriver().navigate().to("");
        waitUntilLandingPageIsLoaded();

        login_positive.LoginBtn();
        login_positive.enterLogin();
        login_positive.enterPassword();
        login_positive.LoginBtnEnter();

    }

}
