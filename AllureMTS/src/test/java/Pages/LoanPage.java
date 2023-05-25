package Pages;

import Data.UserData;
import Tools.SelenideTools;
import org.openqa.selenium.By;
import Data.RandomData.RandomPhoneNumber;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoanPage {

    UserData data = new UserData("","@mail.ru","Алексеев Алексей Алексеевич","36","1000000","","");

    SelenideTools selTools = new SelenideTools();

    private final By LOAN_CALCULATION = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 jLWLXd ButtonText-sc-48arcs-2 ivMpRV'])[5]");

    private final By COST_REAL_STATE_LOAN = By.xpath("(//*[@data-testid='input-slider'])[1]");

    private final By TERM_LOAN = By.xpath("(//*[@data-testid='input-slider'])[2]");


    private final By FULL_NAME = By.xpath("//*[@name='clientFio']");


    private final By PHONE_NUMBER = By.xpath("//*[@name='phoneNumber']");

    private final By EMAIL = By.xpath("//*[@type='email']");

    private final By BUTTON_NEXT = By.xpath("//div[@class='Wrapper-sc-1vydk7-0 jLWLXd ButtonText-sc-48arcs-2 jInSIF']");

    private final By ASSERT_EMAIL = By.xpath("//div[@class='Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf styled__InputHelperTextWithIndent-sc-1l7185y-0 iLSKfQ']");

    /*element.sendKeys(Keys.chord(Keys.CONTROL, "a"));*/
    public LoanPage offerLoan() {
        String randNumber = RandomPhoneNumber.tsifri();
        selTools.clickButton(LOAN_CALCULATION);
        selTools.clearButton(COST_REAL_STATE_LOAN, data.getSum());
        selTools.clearButton(TERM_LOAN, data.getTerm());
        selTools.sendKeysButton(FULL_NAME, data.getFullName());
        selTools.sendKeysButton(PHONE_NUMBER, randNumber);
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.clickButton(BUTTON_NEXT);
        return this;
    }

    public LoanPage failureOfferLoanIncorrectEmail() {
        $(ASSERT_EMAIL).shouldHave(text("Введите верный электронный адрес"));
        return this;
    }
}
