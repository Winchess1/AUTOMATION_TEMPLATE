package RollingSlots.UI.forgot_password;

import RollingSlots.BasePage.BasePage;
import io.qameta.allure.Step;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import services.Translations;

import java.security.SecureRandom;

import static Configuration.utils.Waiter.*;
import static org.junit.Assert.assertEquals;

public class forgot_password extends BasePage {
    private static Translations translations = new Translations();
    SecureRandom random = new SecureRandom();

//
//    @FindBy(how = How.CLASS_NAME, using = "burger")
//    public WebElement burger;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-sidebar/div/aside/div/div[4]/button[1]")
    public WebElement LoginBtn;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-login/div/div/div/div/div[2]/form/div[4]/a")
    public WebElement forgotLnk;

    @FindBy(how = How.CLASS_NAME, using = "popup__bg")
    public WebElement resetPopUp;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-reset-password/div/div/div/div/div[2]/form/div[1]/input")
    public WebElement emailReset;

    @FindBy(how = How.CLASS_NAME, using = "trg-popupreser-reset")
    public WebElement resetBtn;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-reset-password/div/div/div/div/div[2]/form/div[2]/div")
    public WebElement errorEmail1;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div")
    public WebElement errorEmail2;

//    public void ClickBurger() {
//        waitAndClick(burger);
//    }
@Step("Нажатие на Логин кнопку SideBar")
    public void LoginBtn() {
        waitAndClick(LoginBtn);
    }
    @Step("Нажатие на Forgot password")
    public void forgotLnk() {
        waitAndClick(forgotLnk);
//		waitUntilElementIsVisible(forgotLnk);
    }
    @Step("проверка на пустое значение")
    public void emailResetEmptyField() {
        clearAndSend(emailReset, "");

    }
    @Step("Нажатие на кнопку Reset Password")
    public void ResetBtnEnter() {
        waitAndClick(resetBtn);
    }
    @Step("Проверка текста ошибки \"Enter E-mail\" ")
    public void checkEmptyMessage() {
        JSONObject Translates = translations.Translations();
        String translate = Translates.get("Email is required").toString();
        System.out.println(translate);
        waitUntilElementIsVisible(errorEmail1);
//        waitTextIs(errorEmail1,"Введите адрес электронной почты");
        assertEquals(translate,errorEmail1.getText());

    }
    @Step("Нажатие на кнопку Reset Password")
    public void emailResetWrongUser() {
        clearAndSend(emailReset, random.nextInt(1000000)+"@gmail.com");

    }
    @Step("Проверка текста ошибки \"User not found\" ")
    public void checkWrongMessage() {
        JSONObject Translates = translations.Translations();
        String translate = Translates.get("No user provided").toString();

        waitUntilElementIsVisible(errorEmail2);
        assertEquals(translate,errorEmail2.getText());

    }
}
