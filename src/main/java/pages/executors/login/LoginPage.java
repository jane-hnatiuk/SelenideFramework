package pages.executors.login;

import pages.AbstractPage;
import pages.locators.LoginLocators;
import util.enums.CredentialType;
import util.objects.Users;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    private LoginLocators locators;
    private Users users;

    public LoginPage(LoginLocators locators, Users users) {
        this.locators = locators;
        this.users = users;
    }

    public void enterUsername(CredentialType type) {
        locators.usernameInput.sendKeys(users.getUser(type).getUsername());
    }

    public void enterPassword(CredentialType type) {
        locators.passwordInput.sendKeys(users.getUser(type).getPassword());
    }

    public void submit() {
        locators.submitButton.click();
    }

    public void loginSubmit(CredentialType type) {
        enterUsername(type);
        enterPassword(type);
        submit();
    }

    public boolean isUsernameErrorMessageDisplayed()    {
        return locators.messageUsernameError.isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed()    {
        return locators.messagePasswordError.isDisplayed();
    }
}
