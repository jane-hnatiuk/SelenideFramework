package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class AbstractLocatos {
    public SelenideElement sectionTitle = $("h3.section-title");
    public ElementsCollection sectionContent = $$(By.className("widget"));
}
