package pages;

import util.enums.PageType;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class AbstractPage {
    public static final String EMPTY_STRING = "";

    public void openPage(PageType page) {
        switch (page) {
            default: //MyPGS
                open("/");
                break;
        }
    }

    public void openLoginPage(PageType page) {
        getWebDriver().manage().deleteAllCookies();
        openPage(page);
    }

    public void logout() {    }
}
