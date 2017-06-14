package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.executors.navigationBar.NavigationBarModule;
import pages.executors.searchResults.SearchResultPage;
import util.enums.CredentialType;
import util.objects.Users;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchUserSteps {

    NavigationBarModule navigationBar;
    SearchResultPage searchResult;

    public SearchUserSteps(NavigationBarModule navigationBar, SearchResultPage searchResult) {
        this.navigationBar = navigationBar;
        this.searchResult = searchResult;
    }

    @When("I search for ([\"]*) user")
    public void I_search_for_user(CredentialType type) throws Throwable {
        navigationBar.searchUser(type);
    }

    @Then("user details ([\"]*) be displayed on results list")
    public void user_details_displayed_on_results_list(String displayed) throws Throwable {
      //  boolean isResult = !displayed.contains("not");
        $(searchResult.getSearchResult().shouldHave(text(Users.DEFAULT.getEmail())));
        //assertTrue(searchResult.isSearchResultDisplayed(isResult));
      //  if (isResult) searchResult.getSearchResult().shouldHave(text(Users.DEFAULT.getEmail()));
    }
}
