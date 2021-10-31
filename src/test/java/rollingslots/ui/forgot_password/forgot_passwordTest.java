package rollingslots.ui.forgot_password;
import RollingSlots.UI.forgot_password.forgot_password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Configuration.utils.DriverFactory.runDriverFromEnvTest;
import static Configuration.utils.Waiter.waitUntilLandingPageIsLoaded;


public class forgot_passwordTest {
    private final forgot_password forgot_password = new forgot_password();
    @Test
    @DisplayName("Login with account - positive")
    void contextLoads() {
        runDriverFromEnvTest();
        waitUntilLandingPageIsLoaded();
        forgot_password.LoginBtn();
        forgot_password.forgotLnk();
        forgot_password.emailResetEmptyField();
        forgot_password.ResetBtnEnter();
        forgot_password.checkEmptyMessage();
        forgot_password.emailResetWrongUser();
        forgot_password.ResetBtnEnter();
        forgot_password.checkWrongMessage();


    }
}
