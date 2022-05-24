import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PlariumTests extends TestBase {

    @Test
    @DisplayName("Проверка ошибочной авторизации")
    void badAuthTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть 'Войти'", () -> {
            loginObjects.loginClick();
        });
        step("Ввести электронную почту", () -> {
            loginObjects.setBadEmail(bademail);
        });
        step("Проверить, что форма авторизации выдала ошибку", () -> {
            loginObjects.checkError(accerror);
        });
    }

    @Test
    @DisplayName("Проверка успешной авторизации")
    void suсcessAuthTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть 'Войти'", () -> {
            loginObjects.loginClick();
        });
        step("Ввести электронную почту", () -> {
            loginObjects.setEmail(email);
        });
        step("Ввести пароль", () -> {
            loginObjects.setPassword(password);
        });
        step("Перейти в профиль ", () -> {
            loginObjects.goToProfile();
        });
        step("Проверить никнейм", () -> {
            loginObjects.checkProfileName(nickname);
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
}
