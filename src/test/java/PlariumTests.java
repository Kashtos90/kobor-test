import com.codeborne.selenide.Selenide;
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
}
