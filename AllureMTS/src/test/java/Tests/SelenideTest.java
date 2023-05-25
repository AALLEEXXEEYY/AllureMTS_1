package Tests;

import Pages.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("Api tests")
@Feature("Local project")
@Story("Методы для работы с пользователем")
@Link(name = "Локальный проект")
@Owner("Шестаков Алексей")
public class SelenideTest extends BaseTest {
    HomePage home = new HomePage();
    DepositPage deposit = new DepositPage();
    CardPage card = new CardPage();
    MortgagePage mortgage = new MortgagePage();
    LoanPage loan = new LoanPage();
    BuisnessandIPPage baip= new BuisnessandIPPage();

    @Description("Открытие депозита с непринятым согласием на обработку данных")
    @Test
    public void takeLoanMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseDeposit();
        deposit.offerDeposit();
        deposit.conditions_for_submitting_an_application();
    }
    @Description("Открытие IT ипотеки для человека которому под конец срока более 65 лет")
    @Test
    public void takeMortgageMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseMortgage();
        mortgage.chooseMortgage();
        mortgage.offerMortgage();
        mortgage.failassertdateofbirth();
    }
    @Description("Открытие карты на человека с латинскими буквами в ФИО")
    @Test
    public void takeCardMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseCard();
        card.chooseCredit();
        card.chooseMtsCard();
        card.issueCard();
        card.failissueCard();
    }
    @Description("Открытие счета для малого бизнесса или ИП с неправильным ИНН ")
    @Test
    public void BuisnessandIP()
            throws InterruptedException
    {
        home.openHomePage().chooseBuisnessandIp();
        baip.clickPaymentAccount();
        baip.failissueINN();
    }
    @Description("Рефинансирование кредита с неверно указанным электронным адресом")
    @Test
    public void LoanMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseLoan();
        loan.offerLoan();
        loan.failureOfferLoanIncorrectEmail();
    }
}