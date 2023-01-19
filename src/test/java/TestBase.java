import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.DriverConfig;
import helpers.PageObjects;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v85.network.Network.clearBrowserCookies;

public class TestBase {
    PageObjects pageObjects = new PageObjects();

    String request = "rj,jh";
    String response = "кобор";

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://kobor.teslaserver.ru/";
        //DriverConfig.configure();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
