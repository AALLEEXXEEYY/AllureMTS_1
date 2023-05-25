package Tests;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUpClass() {
        WebDriverManager.chromedriver().driverVersion("103").setup();
        System.setProperty("chromeoptions.args", "--no-sandbox");
    }

    @AfterEach
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}