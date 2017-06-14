package modules.executors.navigationBar;

import modules.locators.NavigationBarLocators;
import pages.AbstractPage;
import util.enums.CredentialType;
import util.objects.Users;

import java.util.Arrays;
import java.util.List;


public class NavigationBarModule extends AbstractPage {

    protected NavigationBarLocators locators;
    private Users users;

    protected NavigationBarModule() {
    }

    public NavigationBarModule(NavigationBarLocators locators, Users users) {
        this.locators = locators;
        this.users = users;
    }

    public List<String> getAllLinkText() {
        return Arrays.asList(locators.links.getTexts());
    }

    public boolean isNavigationBarDisplayed() {
        return locators.navigation.isDisplayed();
    }

    public void clickLinkById(String caption) {
        locators.linkById(caption).click();
    }

    public void clickLinkByText(String caption) {
        locators.linkByText(caption).click();
    }

    public void searchUser(CredentialType type) {
        locators.inputSearch.clear();
        locators.inputSearch.sendKeys(users.getUser(type).getUsername());
        locators.buttonSearch.click();
    }
}
