package RollingSlots.UI.Login;



import RollingSlots.BasePage.BasePage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static Configuration.utils.Waiter.clearAndSend;
import static Configuration.utils.Waiter.waitAndClick;

public class login_positive extends BasePage {
//    @FindBy(how = How.CLASS_NAME, using = "burger")
//    public WebElement burger;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-sidebar/div/aside/div/div[4]/button[1]")
    public WebElement LoginBtn;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-login/div/div/div/div/div[2]/form/div[1]/input")
    public WebElement email;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main/div/app-login/div/div/div/div/div[2]/form/div[2]/input")
    public WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "trg-popuplogin-login")
    public WebElement LoginBtnEnter;

//    public void ClickBurger() {
//        waitAndClick(burger);
//    }
    @Step("Нажатие на Логин кнопку SideBar")
    public void LoginBtn() {
        waitAndClick(LoginBtn);
    }

    @Step("Вввод Логина")
    public void enterLogin() {
        clearAndSend(email, "test25@gmail.com");
    }

    @Attachment
    public void enterPassword() {
        clearAndSend(password, "123123123");
    }

    @Step("Нажатие на Логин кнопку Pop-Up")
    public void LoginBtnEnter() {
        waitAndClick(LoginBtnEnter);
    }

}
