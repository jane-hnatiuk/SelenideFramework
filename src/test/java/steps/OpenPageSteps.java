package steps;

import cucumber.api.java.en.Given;
import pages.executors.login.LoginPage;
import util.enums.PageType;

public class OpenPageSteps {
    private LoginPage loginPage;

    public OpenPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("I open ([\"]*) portal")
    public void givenIOpenPortal(PageType page) throws Throwable {
        loginPage.openPage(page);
    }

    @Given("I open ([\"]*) portal login page")
    public void givenIOpenLoginPortal(PageType page) throws Throwable {
        loginPage.openLoginPage(page);
    }
}
