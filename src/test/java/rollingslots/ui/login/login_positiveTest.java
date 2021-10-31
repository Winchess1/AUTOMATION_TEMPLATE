package rollingslots.ui.login;

import RollingSlots.UI.Login.login_positive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Configuration.utils.DriverFactory.runDriverFromEnvTest;
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
        runDriverFromEnvTest();
        waitUntilLandingPageIsLoaded();
        login_positive.LoginBtn();
        login_positive.enterLogin();
        login_positive.enterPassword();
        login_positive.LoginBtnEnter();

    }

}
