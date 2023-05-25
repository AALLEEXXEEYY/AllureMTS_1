package Pages;

import Data.RandomData.RandomPhoneNumber;
import Data.UserData;
import Tools.SelenideTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class CardPage {

    UserData data = new UserData("13.05.1989","Allex@mai.ru","Alexseev Alexey Alexseevich","","","","");
    SelenideTools seltools = new SelenideTools();
    private final By CREDIT_CART = By.xpath("//*[@id='__next']/div[3]/div[2]/div/div[1]/div/a[2]/div");
    private final By GET_A_CARD = By.xpath("//*[@id='__next']/div[3]/div[4]/div/div/div[2]/div[4]/div/button/div");
    private final By PHONE_NUMBER = By.xpath("//*[@type='tel']");
    private final By FULL_NAME = By.xpath("//*[@name='clientFio']");
    private final By BIRTH_DATE = By.xpath("//*[@name='birthDate']");
    private final By EMAIL = By.xpath("//*[@type='email']");
    private final By NEXT_BUTTON = By.xpath("//*[@id='FABodyContainer']/form/button/div");
    private final By ASSERT_FIO = By.xpath("//*[@id='FABodyContainer']/form/div[1]/div[2]/div[2]");
    private final By ASSERT_PATRONYMIC = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[4]/div/div[3]/div/div[14]/div/div[2]/form/div[1]/div[2]/div[3]/label/div[2]/div");
    @Step("Выбираем раздел карты")
    public CardPage chooseCredit() {
        seltools.clickButton(CREDIT_CART);
        return this;
    }
    @Step("Выбираем подходящую карту")
    public CardPage chooseMtsCard() {
        seltools.clickButton(GET_A_CARD);
        return this;
    }
    @Step("Заполняем данные,но ФИО латинскими символами")
    public CardPage issueCard() {
        String number = RandomPhoneNumber.tsifri().toString();
        seltools.sendKeysButton(PHONE_NUMBER, number);
        seltools.sendKeysButton(FULL_NAME, data.getFullName());
        seltools.sendKeysButton(BIRTH_DATE, data.getDate());
        seltools.sendKeysButton(EMAIL, data.getMail());
        seltools.clickButton(NEXT_BUTTON);
        return this;
    }
    @Step("Проверка корректности написания ФИО")
    public CardPage failissueCard() {
        $(ASSERT_FIO).shouldBe(visible);
        $(ASSERT_FIO).shouldHave(text("Используйте только кириллицу"));
        return this;
    }

}
