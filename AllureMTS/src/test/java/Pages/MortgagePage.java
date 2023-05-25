package Pages;

import Data.UserData;
import Tools.SelenideTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import Data.RandomData.RandomPhoneNumber;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
public class MortgagePage {

    UserData data = new UserData("15.05.1966","Allex@mai.ru","Алексей Алексеевич Алексеев","36","9000000","3000000", "Москва");
    SelenideTools selTools = new SelenideTools();

    private final By PROGRAMS = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 jLWLXd TabText-sc-tyqhzb-3 faRXmE'])[2]");

    private final By IT_MORTGAGE = By.xpath("//*[@id='__next']/div[3]/div[1]/div/div/div[3]/div[3]/div[2]/div[1]/div[4]/a/div/div[2]/a[1]/div");

    private final By MORTGAGE_CALCULATION = By.xpath("(//*[@data-testid='button'])[2]");

    private final By COST_REAL_STATE = By.xpath("//*[@data-testid='input-slider']");

    private final By AN_INITIAL_FEE = By.xpath("(//*[@data-testid='input-slider'])[2]");

    private final By MORTGAGE_TERM = By.xpath("(//*[@data-testid='input-slider'])[3]");

    public final By FULL_NAME = By.xpath("//*[@name='fullName']");

    private final By DATA_OF_BIRTH = By.xpath("//*[@name='birthDate']");

    private final By PHONE_NUMBER = By.xpath("//*[@name='mobile']");

    private final By EMAIL = By.xpath("//*[@type='email']");

    private final By REGION = By.xpath("//*[@name='region']");
    private final By CHOOSE_REGION = By.xpath("//li[@id='react-autowhatever-1--item-0']");

    private final By BUTTON_NEXT = By.xpath("(//*[@class='Inner-sc-1rfqasg-0 jviKiO Inner-sc-48arcs-0 bqTsRY'])[5]");

    private final By ASSERT_DATA_OF_BIRTH = By.xpath("//*[@id='pers-info-form']/div[1]/div[2]/div[2]");
    @Step("Выбираем ипотеку для IT специалистов")
    public MortgagePage chooseMortgage()  {
        selTools.clickButton(PROGRAMS);
        selTools.clickButton(IT_MORTGAGE);
        return this;
    }
    @Step("Заролняем персональные данные")
    public MortgagePage offerMortgage () {
        String randNumber = RandomPhoneNumber.tsifri();
        selTools.clickButton(MORTGAGE_CALCULATION);
        selTools.clearButton(COST_REAL_STATE, data.getSum());
        selTools.clearButton(AN_INITIAL_FEE, data.getInitialFee());
        selTools.clearButton(MORTGAGE_TERM, data.getTerm());
        selTools.sendKeysButton(FULL_NAME, data.getFullName());
        selTools.sendKeysButton(DATA_OF_BIRTH, data.getDate());
        selTools.sendKeysButton(PHONE_NUMBER, randNumber);
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.sendKeysButton(REGION, data.getRegion());
        selTools.clickButton(REGION);
        selTools.clickButton(CHOOSE_REGION);

        selTools.clickButton(BUTTON_NEXT);
        return this;
    }
    @Step("Проверка возроста на окончание выплаты ипотеки")
    public MortgagePage failassertdateofbirth() {
        $(ASSERT_DATA_OF_BIRTH).shouldHave(text("Возраст клиента должен быть не более 65 лет на дату окончания ипотечного кредитования"));
        return this;
    }


}
