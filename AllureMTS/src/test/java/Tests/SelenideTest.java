package Tests;

import Pages.*;
import org.junit.jupiter.api.Test;
public class SelenideTest extends BaseTest {
    HomePage home = new HomePage();
    DepositPage deposit = new DepositPage();
    CardPage card = new CardPage();
    MortgagePage mortgage = new MortgagePage();
    LoanPage loan = new LoanPage();
    BuisnessandIPPage baip= new BuisnessandIPPage();

    @Test
    public void takeLoanMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseDeposit();
        deposit.offerDeposit();
        deposit.conditions_for_submitting_an_application();
    }

    @Test
    public void takeMortgageMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseMortgage();
        mortgage.chooseMortgage();
        mortgage.offerMortgage();
        mortgage.failassertdateofbirth();
    }

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

    @Test
    public void BuisnessandIP()
            throws InterruptedException
    {
        home.openHomePage().chooseBuisnessandIp();
        baip.clickPaymentAccount();
        baip.failissueINN();
    }

    @Test
    public void LoanMTS()
            throws InterruptedException
    {
        home.openHomePage().chooseLoan();
        loan.offerLoan();
        loan.failureOfferLoanIncorrectEmail();
    }
}