package Pages;
import Data.RandomData.RandomPhoneNumber;
import Data.UserData;
import Tools.SelenideTools;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class BuisnessandIPPage {

    UserData data = new UserData("15.05.1966","Allex@mai.ru","Алексей Алексеевич Алексеев","36","9000000","3000000", "Москва");
    SelenideTools selTools = new SelenideTools();

    private final static By BUTTON_PAYMENT_ACCOUNT = By.xpath("//a [@ href='/malomu-biznesu/raschetny-schet/']");

    private final By PHONE_NUMBER = By.xpath("//input[@type='tel']");

    private final By EMAIL = By.xpath("//input[@placeholder='email@domain.ru']");

    private final By IIN = By.xpath("//input[@placeholder='ИНН или название организации']");

    private final By BUTTON_NEXT = By.xpath("//*[@id='form']/form/div[2]/div[7]/button/div");

    private final By ACCEPT_INN = By.xpath("//*[@id='form']/form/div[2]/div[1]/div[3]/div[2]");


    public BuisnessandIPPage clickPaymentAccount() throws InterruptedException{
        String randNumber = RandomPhoneNumber.tsifri();
        selTools.clickButton(BUTTON_PAYMENT_ACCOUNT);
        selTools.sendKeysButton(PHONE_NUMBER, randNumber);
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.sendKeysButton(IIN, randNumber);
        Thread.sleep(2000);
        selTools.clickButton(BUTTON_NEXT);
        return this;
    }
    public BuisnessandIPPage failissueINN() {
        $(ACCEPT_INN).shouldBe(visible);
        $(ACCEPT_INN).shouldHave(text("ИНН некорректный, проверьте правильность написания"));
        return this;
    }
}
