package pages.locators;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import pages.AbstractLocatos;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultLocators extends AbstractLocatos {
    public ElementsCollection searchResults = $$(By.className("personSearchResult"));

    public SearchResultLocators() {    }
}
