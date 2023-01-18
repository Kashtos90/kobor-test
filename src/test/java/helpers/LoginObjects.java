package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginObjects {

    public SelenideElement
            closeCity = $(withText("Да, верно")),
            searchSection = $(withText("Поиск")),
            searchResults = $(".cFaInH");

    public LoginObjects approveClick() {
        closeCity.click();

        return this;
    }

    public LoginObjects searchClick() {
        searchSection.click();

        return this;
    }

    public LoginObjects setRequest (String request) {
        searchResults.setValue(request);

        return this;
    }

    public LoginObjects checkResults (String response) {
        searchResults.shouldHave(text(response));

        return this;
    }
}