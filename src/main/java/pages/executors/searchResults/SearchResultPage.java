package pages.executors.searchResults;

import com.codeborne.selenide.SelenideElement;
import pages.AbstractPage;
import pages.enums.PageMessages;
import pages.locators.SearchResultLocators;
import util.helpers.ElementByTextHelper;

public class SearchResultPage extends AbstractPage {

    private SearchResultLocators locators;
    private ElementByTextHelper helper;

    public SearchResultPage(SearchResultLocators locators, ElementByTextHelper helper) {
        this.locators = locators;
        this.helper = helper;
    }

    public boolean isSearchResultDisplayed(boolean isResult) {
        if (isResult) {
            return !locators.searchResults.isEmpty();
        }
        return helper.isElementWithTextDisplayed(locators.sectionContent, PageMessages.noSearchResults.get());
    }

    public SelenideElement getSearchResult() {
        return locators.searchResults.get(0);
    }
}
