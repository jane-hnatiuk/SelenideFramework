package modules.executors.pageHeader;

import com.codeborne.selenide.SelenideElement;
import modules.locators.PageHeaderLocators;
import pages.AbstractPage;
import pages.enums.PageTitle;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class PageHeaderModule extends AbstractPage {

    protected PageHeaderLocators locators;

    public PageHeaderModule(PageHeaderLocators locators) {
        this.locators = locators;
    }

    public SelenideElement getHeaderTextElement() {
        return locators.headerText;
    }

    public void logout() {
        locators.headerLogoutLink.click();
    }

    public boolean isLogoutLinkDisplayed() {
        return locators.headerLogoutLink.isDisplayed();
    }

    public boolean isPageHeaderDisplayed() {
        if (!locators.headerText.has(text(PageTitle.headerPage.get()))) return false;
        return locators.headerLogoutLink.isDisplayed();
    }
}
