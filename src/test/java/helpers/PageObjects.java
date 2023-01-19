package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PageObjects {

    public SelenideElement
            closeCity = $("#__next"),
            searchSection = $(withText("Поиск")),
            searchResults = $(".cFaInH");

    public PageObjects cityClose() {
        closeCity.pressEscape();

        return this;
    }

    public PageObjects searchClick() {
        searchSection.click();

        return this;
    }

    public PageObjects setRequest (String request) {
        searchResults.setValue(request);

        return this;
    }

    public PageObjects checkResults (String response) {
        searchResults.shouldHave(text(response));

        return this;
    }
}