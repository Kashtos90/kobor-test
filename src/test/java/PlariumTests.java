import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class PlariumTests extends TestBase {

    @Test
    @DisplayName("Проверка ошибочной авторизации")
    void badAuthTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть 'Войти'", () -> {
            $(withText("Войти")).click();
        });
        step("Ввести электронную почту", () -> {
            $("#email").setValue("29061900a@gmail.com").pressEnter();
        });
        step("Проверить, что форма авторизации выдала ошибку", () -> {
            $(".cWCQHG").shouldHave(text("Пользователь с таким адресом электронной почты не найден. Проверь адрес, зарегистрируйся или обратись в службу поддержки Plarium"));
        });
    }

    @Test
    @DisplayName("Проверка успешной авторизации")
    void suсcessAuthTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть 'Войти'", () -> {
            $(withText("Войти")).click();
        });
        step("Ввести электронную почту", () -> {
            $("#email").setValue("29061990a@gmail.com").pressEnter();
        });
        step("Ввести пароль", () -> {
            $("#password").setValue("rfinetd29").pressEnter();
        });
        step("Перейти в профиль ", () -> {
            $(".giJlUH").click();
        });
        step("Проверить никнейм", () -> {
            $(".fFgwTx").shouldHave(text("Kashtos90"));
        });
    }

    @Test
    @DisplayName("Проверка отображения блога")
    void blogTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Навести курсор на 'Сообщество'", () -> {
            $(withText("Сообщество")).hover();
        });
        step("Ссылка на 'Блог' отображается во вкладке", () -> {
            $("a[href='/ru/blog/']").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка англ. языка")
    void languageTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть на выбор языка", () -> {
            $(".fOCTmG").click();
        });
        step("В списке присутствует англ. язык", () -> {
            $(".ktyeqt").shouldHave(text("English"));
        });
    }

    @Test
    @DisplayName("Проверка списка жанров")
    void genreTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Навести курсор на 'Игры'", () -> {
            $(withText("Игры")).hover();
        });
        step("Элемент 'Жанры' содержит 'Стратегии'", () -> {
            $(".dkxMtQ").shouldHave(text("Стратегии"));
        });
    }

    @Test
    @DisplayName("Проверка успешной авторизации (+API)")
    void suсcessAuthTestApi() {
            String authorizationCookie =
                    given()
                            .contentType("application/json; charset=utf-8")
                            .formParam("email", "29061990a@gmail.com")
                            .formParam("password", "87b3c3e7d56351a441e85241ac25096aae4eee26566756c263fe5bfbc5d5217792bfbe64676d0e20268ddd9a4b41f74aa337207feeb173080440b1c99848b815")
                            .when()
                            .post(baseUrl + "Войти")
                            .then()
                            .statusCode(301)
                            .extract()
                            .cookie("portal.auth.v31=18964546AD9D763A5A607D75502614D66CBAC3DA376100F0AA21F45D765F2580DD99BF0D13B025386A7C51A10776260DD940EFD3FB4065186FC34BD2959E5336218D561637B886F4B5E1C08F29CBE285153974D6BCC1561A988FEB4BE20E599B407402C594CBEF61E4D13EDE4A83517BDFA34F4B339FE9C3F6AC3029543D6D46C6B0545805685D680971FB90A08079853851D91068D8D3248533D195E36070CA516685013A89FBC27D07A11A0A6F373B2E8E696C0357463CE09EB3768A8000F98666A773DFB8227AC2D2A0814DA3A31F5CA6BE314D271BB8D79CDEAD118BA857B951247619534A9AED4856560256AEF2BE18DC5C2EDED3671C4BC7B02EE0F10130E01C5A70DC42AADAE06E6FCAA9A80149703D4121B17AF4C8B9F635FEC056F01C507155BAF2DAE37DD6EB1A3563442596F9C7E8737A4A16F707DB126ED837F9D4BFAD2B752C7000474FD8B59DFC9E67E16DDA1F1CAD2F25710C50433FF4266133F3536C; Path=/; Secure; Expires=Sat, 21 May 2022 14:08:24 GMT;");
            //внести cookie через главную страницу
            open(baseUrl);
            getWebDriver().manage().addCookie(new Cookie("portal.auth.v31=18964546AD9D763A5A607D75502614D66CBAC3DA376100F0AA21F45D765F2580DD99BF0D13B025386A7C51A10776260DD940EFD3FB4065186FC34BD2959E5336218D561637B886F4B5E1C08F29CBE285153974D6BCC1561A988FEB4BE20E599B407402C594CBEF61E4D13EDE4A83517BDFA34F4B339FE9C3F6AC3029543D6D46C6B0545805685D680971FB90A08079853851D91068D8D3248533D195E36070CA516685013A89FBC27D07A11A0A6F373B2E8E696C0357463CE09EB3768A8000F98666A773DFB8227AC2D2A0814DA3A31F5CA6BE314D271BB8D79CDEAD118BA857B951247619534A9AED4856560256AEF2BE18DC5C2EDED3671C4BC7B02EE0F10130E01C5A70DC42AADAE06E6FCAA9A80149703D4121B17AF4C8B9F635FEC056F01C507155BAF2DAE37DD6EB1A3563442596F9C7E8737A4A16F707DB126ED837F9D4BFAD2B752C7000474FD8B59DFC9E67E16DDA1F1CAD2F25710C50433FF4266133F3536C; Path=/; Secure; Expires=Sat, 21 May 2022 14:08:24 GMT;", authorizationCookie));
            //открыть страницу профиля для проверки
            open(baseUrl);
            $(".giJlUH").click();
            $(".fFgwTx").shouldHave(text("Kashtos90"));
    }
}
