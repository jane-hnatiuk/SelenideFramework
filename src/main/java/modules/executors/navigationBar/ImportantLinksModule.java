package modules.executors.navigationBar;

import modules.enums.ImportantLinkName;
import modules.locators.NavigationBarLocators;
import util.helpers.ElementByTextHelper;
import util.objects.Users;

public class ImportantLinksModule extends NavigationBarModule {

    ElementByTextHelper helper;

    public ImportantLinksModule(NavigationBarLocators locators,
                                Users users,
                                ElementByTextHelper helper) {
        super(locators, users);
        this.helper = helper;
    }

    public boolean isLinkDisplayed(ImportantLinkName linkType) {
        return helper.isElementWithTextDisplayed(locators.links, linkType.get());
    }
}
