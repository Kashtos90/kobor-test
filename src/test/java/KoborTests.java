import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class KoborTests extends TestBase {

    @Test
    @DisplayName("Проверка автозамены запроса")
    void autocorrectTest() {
        step("Открыть главную страницу", () -> {
            open(baseUrl);
        });
        step("Потвердить город", () -> {
            pageObjects.approveClick();
        });
        step("Кликнуть на поисковую строку", () -> {
            pageObjects.searchClick();
        });
        step("Ввести запрос кириллицей на англ. раскладке", () -> {
            pageObjects.setRequest(request);
        });
        step("В результатах поиска отображается запрос на кириллице", () -> {
            pageObjects.checkResults(response);
        });
    }
}