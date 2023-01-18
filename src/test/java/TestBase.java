import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.DriverConfig;
import helpers.LoginObjects;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v85.network.Network.clearBrowserCookies;

public class TestBase {
    LoginObjects loginObjects = new LoginObjects();

    String request = "rj,jh";
    String bademail = "29061900a@gmail.com";
    String accerror = "Пользователь с таким адресом электронной почты не найден. Проверь адрес, зарегистрируйся или обратись в службу поддержки Plarium";
    String password = "rfinetd29";
    String nickname = "Kashtos90";

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://kobor.teslaserver.ru/";
       // DriverConfig.configure();

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
