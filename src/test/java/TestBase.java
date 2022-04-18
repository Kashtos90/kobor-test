import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import helpers.AllureAttach;
import helpers.Attach;
import helpers.DriverConfig;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.sessionId;
import static org.openqa.selenium.devtools.v85.network.Network.clearBrowserCookies;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://plarium.com/ru";
        DriverConfig.configure();

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

        if (Project.isVideoOn()) {
            AllureAttach.addVideo(sessionId);
        }
    }
}
