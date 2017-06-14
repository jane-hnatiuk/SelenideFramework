package steps;

import com.codeborne.selenide.commands.ShouldBe;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.executors.pageHeader.PageHeaderModule;
import pages.enums.PageTitle;
import pages.executors.login.LoginPage;
import util.enums.CredentialType;
import util.enums.PageType;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginLogoutPageSteps {
	private LoginPage loginPage;
    private PageHeaderModule pageHeader;

	public LoginLogoutPageSteps(LoginPage loginPage, PageHeaderModule pageHeader) {
        this.loginPage = loginPage;
        this.pageHeader = pageHeader;
	}

	// logout implementation

	@Given("I am logged to ([\"]*) portal")
	public void givenIAmLoggedToPortal(PageType page) throws Throwable {
        if (!pageHeader.isLogoutLinkDisplayed()) {
            loginPage.openLoginPage(page);
            loginPage.loginSubmit(CredentialType.valid);
        }
	}

	@When("I press ([\"]*) logout button")
	public void whenIPresLogoutButton(PageType page) throws Throwable {
        pageHeader.logout();
	}

	// main implementation

	@When("I enter ([\"]*) username")
	public void whenIEnterUsername(CredentialType type) throws Throwable {
		loginPage.enterUsername(type);
	}

	@When("I enter ([\"].*) password")
	public void whenIEnterPassword(CredentialType type) throws Throwable {
		loginPage.enterPassword(type);
	}

	@When("I submit login")
	public void whenISubmitLogin() throws Throwable {
		loginPage.submit();
	}

	@Then("I am not logged into ([\"]*) portal")
	public void thenIAmNotLoggedIntoPortal(PageType page) throws Throwable {
      //  assertEquals(PageTitle.titleLogin.get(), title());
        $(PageTitle.titleLogin.get()).should(matchText(title()));
	}

	@Then("I am logged into ([\"]*) portal")
	public void thenIAmLoggedIntoPortal(PageType page) throws Throwable {
        $(pageHeader.getHeaderTextElement().shouldHave(text(PageTitle.headerPage.get())));
		$(String.valueOf(pageHeader.isLogoutLinkDisplayed()));
		// $("input").shouldHave(exactText("Some text"));
      	//assertTrue(pageHeader.isLogoutLinkDisplayed());
		//
	}

    @Then("Login error messages are displayed")
    public void Login_error_messages_are_displayed() throws Throwable {
	$(String.valueOf(loginPage.isUsernameErrorMessageDisplayed()));
	$(String.valueOf(loginPage.isPasswordErrorMessageDisplayed()));
//		assertTrue(loginPage.isUsernameErrorMessageDisplayed());
//		assertTrue(loginPage.isPasswordErrorMessageDisplayed());
    }
}
