package Pages;

import Tools.SelenideTools;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    SelenideTools selTools = new SelenideTools();

    private final By DROP_DOWN = By.xpath("//*[@data-testid='icon_baseX16/arrowDown']");

    private final static By BUSINESS_AND_IP = By.xpath("//a [@ href='/malomu-biznesu/']");

    private final By DEPOSIT = By.xpath("(//*[@class='sc-jJEKmz ejANpH'])[2]");

    private final By CARDS = By.xpath("//*[@id='__next']/div[1]/nav/div[1]/div[1]/div[1]/a[1]/div");

    private  final By IPOTEKA = By.xpath("(//*[@class='sc-jJEKmz ejANpH'])[4]");

    private final By CREDITY = By.xpath("(//*[@class='sc-jJEKmz ejANpH'])[3]");

    private ChromeDriver driver;

//    throws InterruptedException (USE IF BAD INTERNET TO SLEEP AND VAIT)
    @Step("Открыть страницу МТС банка")
    public HomePage openHomePage() throws InterruptedException  {
        Selenide.open("https://www.mtsbank.ru/");
        Thread.sleep(5000);
        return this;
    }
    @Step("Выбрать вкладку депозит")
    public HomePage chooseDeposit() {
        selTools.clickButton(DEPOSIT);
        return this;
    }
    @Step("Выбрать вкладку ипотека")
    public HomePage chooseMortgage() {
        selTools.clickButton(IPOTEKA);
        return this;
    }
        @Step("Выбрать вкладку карты")
    public HomePage chooseCard() {
        selTools.clickButton(CARDS);
        return this;
    }
    @Step("Выбрать вкладку кредит")
    public HomePage chooseLoan() {
        selTools.clickButton(CREDITY);
        return this;
    }
    @Step("Раскрыть дроп даун и выбрать вкладку бизнесс и ИП")
    public HomePage chooseBuisnessandIp() {
        selTools.clickButton(DROP_DOWN);
        selTools.clickButton(BUSINESS_AND_IP);
        return this;
    }
}
