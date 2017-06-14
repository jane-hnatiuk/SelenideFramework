package util.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.NoSuchElementException;

public class ElementByTextHelper {

    public boolean isElementWithTextDisplayed(ElementsCollection elements, String caption) {
        try {
            return getElementWithText(elements, caption).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public SelenideElement getElementWithText(ElementsCollection elements, String caption)   {
        return elements.stream().filter(s -> s.text().equals(caption)).findFirst().get();
    }
}
