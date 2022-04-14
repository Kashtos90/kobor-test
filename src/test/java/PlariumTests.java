import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PlariumTests extends TestBase {

    @Test
    @DisplayName("Проверка ошибочной авторизации")
    void badAutorisation() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть Войти", () -> {
            $(withText("Войти")).click();
        });
        step("Ввести элетронную почту", () -> {
            $("#email").setValue("29061900a@gmail.com");
        });
        step("Кликнуть Далее", () -> {
            $(withText("Далее")).click();
        });
        step("Проверить, что форма авторизации выдала ошибку", () -> {
            $("button[data-qa-entity=auth.next.step]").shouldHave(text("Пользователь с таким адресом электронной почты не найден. Проверь адрес, зарегистрируйся или обратись в службу поддержки Plarium"));
        });
    }

    @Test
    @DisplayName("Проверка успешной авторизации")
    void suсcessAutorisation() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть Войти", () -> {
            $(withText("Войти")).click();
        });
        step("Ввести элетронную почту", () -> {
            $("#email").setValue("29061990a@gmail.com");
        });
        step("Кликнуть Далее", () -> {
            $(withText("Далее")).click();
        });
        step("Ввести пароль", () -> {
            $("#password").setValue("rfinetd29");
        });
        step("Кликнуть Войти", () -> {
            $(withText("Войти")).click();
        });
        step("Перейти в профиль ", () -> {
            $(withText("Показать")).click();
        });
        step("Проверить никнейм", () -> {
            $("div[data-qa-entity=auth.send.button]").click();
        });
    }
}
