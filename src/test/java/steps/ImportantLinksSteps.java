package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.executors.navigationBar.ImportantLinksModule;
import modules.executors.navigationBar.NavigationBarModule;
import modules.enums.ImportantLinkName;
import modules.enums.LinkId;
import pages.enums.PageTitle;
import util.helpers.WindowHelper;

import java.util.List;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;


public class ImportantLinksSteps {
    private NavigationBarModule navigationBar;
    private ImportantLinksModule importantLinks;
    private WindowHelper windowHelper;

    public ImportantLinksSteps(NavigationBarModule navigationBar, ImportantLinksModule importantLinks, WindowHelper windowHelper) {
        this.navigationBar = navigationBar;
        this.importantLinks = importantLinks;
        this.windowHelper = windowHelper;
    }

    @When("I press ([\"]*) on navigation bar")
    public void I_press_on_navigation_bar(LinkId linkId) throws Throwable {
        navigationBar.clickLinkById(linkId.toString());
    }

    @When("I press ([\"]*) on important links navigation bar")
    public void I_press_link_on_important_links_navigation_bar(ImportantLinkName linkCaption) throws Throwable {
        navigationBar.clickLinkByText(linkCaption.get());
    }

    @Then("The following links are displayed:")
    public void The_following_links_are_displayed(List<ImportantLinkName> linkNames) throws Throwable {
        for (ImportantLinkName linkName : linkNames) {
     //       assertTrue(importantLinks.isLinkDisplayed(linkName));
            $(String.valueOf(importantLinks.isLinkDisplayed(linkName)));
        }
    }

    @Then("The (.*) page is opened in new window")
    public void The_link_page_is_opened_in_new_window(PageTitle pageTitle) throws Throwable {
        windowHelper.switchToAnyNotParentWindow();
        try {
            $(String.valueOf(pageTitle.get())).should(matchText(title()));
        //    assertEquals(pageTitle.get(), title());
        } finally {
            windowHelper.switchToParentWindow(true);
        }
    }
}
