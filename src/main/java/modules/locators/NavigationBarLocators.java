package modules.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationBarLocators {
    public SelenideElement navigation = $("div.navbar-collapse");

    public SelenideElement inputSearch = $("div.navbar-collapse").find(By.id("phrase"));
    public SelenideElement buttonSearch = $("div.navbar-collapse").find(By.id("SearchButton"));

    public ElementsCollection links = $$("div.navbar-collapse ul#MainListMenu li a");

    public SelenideElement linkById(String linkId) {
        return $("div.navbar-collapse ul#MainListMenu li#" + linkId + " a");
    }

    public SelenideElement linkByText(String linkText) {
        return links.stream().filter(s -> s.text().equals(linkText)).findFirst().get();
    }

    public NavigationBarLocators() {}
}
