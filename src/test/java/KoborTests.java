import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class KoborTests extends TestBase {

    @Test
    @DisplayName("Проверка автозамены запроса")
    void blogTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Кликнуть на поисковую строку", () -> {
            $(withText("Поиск")).click();
        });
        step("Ввести 'RJ<JH'", () -> {
            $(withText("Поиск")).click();
        });
    }
}