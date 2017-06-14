package util.helpers;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Iterator;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.title;

public class WindowHelper {

    private static String parentWindowHandle = getWebDriver().getWindowHandle();

    private void areWindowsAvailable() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return getWebDriver().getWindowHandles().size() > 1;
            }
        });
    }

    public void switchToWindow(String windowHandle) {
        Selenide.switchTo().window(windowHandle);
    }

    public void switchToParentWindow() {
        switchToParentWindow(false);
    }

    public void switchToParentWindow(boolean closeOtherAfterSwitch) {
        if (getWebDriver().getWindowHandles().size() != 1) {
            if (!getWebDriver().getWindowHandle().equals(parentWindowHandle)) {
                getWebDriver().close();
            }
        }
        switchToWindow(parentWindowHandle);
    }

    public void switchToAnyNotParentWindow() {
        areWindowsAvailable();
        Iterator<String> windowIterator = getWebDriver().getWindowHandles().iterator();

        while (windowIterator.hasNext()) {
            String windowHandle = windowIterator.next();

            if (!windowHandle.equals(parentWindowHandle)) {
                switchToWindow(windowHandle);
                return;
            }
        }
        switchToParentWindow();
    }

    public void switchToWindowWithTitle(String title) {
        if (title().contains(title)) return;

        areWindowsAvailable();
        Iterator<String> windowIterator = getWebDriver().getWindowHandles().iterator();

        while (windowIterator.hasNext()) {
            String windowHandle = windowIterator.next();

            switchToWindow(windowHandle);
            if (title().contains(title)) {
                return;
            }
        }

        switchToParentWindow();
    }
}
