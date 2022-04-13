import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

public class PlariumTests extends TestBase {

    @Test
    @DisplayName("Проверка авторизации")
    void checkSearchPage() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть Войти", () -> {
            $("button[data-qa-entity=header.login]").click();
        });
        step("Ввести элетронную почту", () -> {
            $("#email").setValue("29061900a@gmail.com");
        });
        step("Кликнуть Далее", () -> {
            $("button[data-qa-entity=auth.next.step]").click();
        });
        step("Проверить, что форма авторизации выдала ошибку", () -> {
            $("button[data-qa-entity=auth.next.step]").shouldHave(text("Пользователь с таким адресом электронной почты не найден. Проверь адрес, зарегистрируйся или обратись в службу поддержки Plarium"));
        });
    }

}
