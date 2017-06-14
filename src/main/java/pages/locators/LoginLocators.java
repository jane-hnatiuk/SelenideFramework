package pages.locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginLocators {
    public SelenideElement logoClass = $("a.logo");
    public SelenideElement logoText = $("a.logo").find("span");
    public SelenideElement usernameInput = $(By.id("userNameBox"));
    public SelenideElement passwordInput = $(By.id("passBox"));
    public SelenideElement submitButton = $(By.id("logon"));

    public SelenideElement messageUsernameError = $(".field-validation-error + #userNameBox");
    public SelenideElement messagePasswordError = $(".field-validation-error + #passBox");

    public LoginLocators() {    }
}
