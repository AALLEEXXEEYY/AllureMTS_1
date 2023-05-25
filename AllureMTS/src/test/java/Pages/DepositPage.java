package Pages;

import Data.RandomData.RandomPhoneNumber;
import Data.UserData;
import Tools.SelenideTools;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
public class DepositPage {
    UserData data = new UserData("","Allex@mai.ru","Алексей Алексеевич Алексеев","12","5000000","","");
    SelenideTools selTools = new SelenideTools();
    private final By CHOOSE_PREMIALNI_MTS = By.xpath("/html/body/div/div[3]/div[1]/div/div/div[9]/div/div[3]/a[1]/div");
    private final By SUM_DEPOSIT = By.xpath("(//*[@data-testid='input-slider'])[1]");
    private final By TERM_DEPOSIT = By.xpath("(//*[@data-testid='input-slider'])[2]");
    private final By FULL_NAME = By.xpath("//textarea[@name='fio']");
    private final By PHONE_NUMBER = By.xpath("//input[@type='tel']");
    private final By CHOOSE_CITY = By.xpath("//input[@placeholder='Выберите город']");
    private final By NAME_CITY = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[4]/div/div[4]/div[1]/div[7]/div[2]/form/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/div[22]/div");
    private final By CHOOSE_OFFICE = By.xpath("//input[@name='department']");
    private final By NAME_OFFICE = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[4]/div/div[4]/div[1]/div[7]/div[2]/form/div[1]/div[4]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/div[5]/div");
    private final By EMAIL = By.xpath("//*[@type='email']");
    private final By CONSENT = By.xpath("//*[@id='depositForm']/div[2]/form/div[3]/label/div[1]");
    private final By BUTTON_NEXT = By.xpath("//*[@id='depositForm']/div[2]/form/button");
    private final By CONSENT_ERROR = By.xpath("//*[@id='depositForm']/div[2]/form/div[4]");

        public DepositPage offerDeposit() {
        String randNumber = RandomPhoneNumber.tsifri();
        selTools.clickButton(CHOOSE_PREMIALNI_MTS);
        selTools.clearButton(SUM_DEPOSIT, data.getSum());
        selTools.clearButton(TERM_DEPOSIT, data.getTerm());
        selTools.sendKeysButton(FULL_NAME, data.getFullName());
        selTools.sendKeysButton(PHONE_NUMBER, randNumber);
        selTools.clickButton(CHOOSE_CITY);
        selTools.clickButton(NAME_CITY);
        selTools.clickButton(CHOOSE_OFFICE);
        selTools.clickButton(NAME_OFFICE);
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.clickButton(CONSENT);
        selTools.clickButton(BUTTON_NEXT);
        return this;
    }

    public DepositPage conditions_for_submitting_an_application() {
        $(CONSENT_ERROR).shouldHave(text("Вы должны принять условия для отправки заявки"));
        return this;
    }
}
