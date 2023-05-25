package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class SelenideTools {
    public SelenideTools clickButton(By CLICK_BUTTON) {
        $(CLICK_BUTTON).shouldBe(visible);
        $(CLICK_BUTTON).click();
        return this;
    }
    public SelenideTools clearButton(By SENDKEYS_BUTTON, String key) {
        $(SENDKEYS_BUTTON).shouldBe(visible);
        $(SENDKEYS_BUTTON).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
        $(SENDKEYS_BUTTON).sendKeys(key);
        return this;
    }
    public SelenideTools sendKeysButton(By SENDKEYS_BUTTON, String key) {
        $(SENDKEYS_BUTTON).shouldBe(visible);
        $(SENDKEYS_BUTTON).sendKeys(key);
        return this;
    }
}
