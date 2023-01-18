import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class KoborTests extends TestBase {

    @Test
    @DisplayName("Проверка автозамены запроса")
    void doublingTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Потвердить город", () -> {
            loginObjects.approveClick();
        });
        step("Кликнуть на поисковую строку", () -> {
            loginObjects.searchClick();
        });
        step("Ввести запрос кириллицей на англ. раскладке", () -> {
            $(withText("Поиск")).click();
        });
        step("В результатах поиска отображается запрос на кириллице", () -> {
            loginObjects.searchClick();
        });
    }
}