package modules.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageHeaderLocators {
    public SelenideElement headerText = $("div.page-header h1");
    public SelenideElement headerLogoutLink = $("div.header-links").find(By.id("logutLink"));

    public ElementsCollection headerLinks = $$("div.header-links");
    public SelenideElement headerVersionLink = $("div.header-links").find(By.id("version"));
    public SelenideElement headerFeedbackLink = $("div.header-links").find(By.id("feedback"));
    public SelenideElement headerEditProfileLink = $("div.header-link").find(By.cssSelector("[href*='profil']"));

    public PageHeaderLocators()    {}
}
