package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginObjects {

    public SelenideElement
            errorSection = $(".cWCQHG"),
            loginButton = $(withText("Войти")),
            emailInput = $("#email"),
            passwordInput = $("#password"),
            profilePage = $(".giJlUH"),
            nickName = $(".fFgwTx");

    public LoginObjects checkError (String accerror) {
        errorSection.shouldHave(text(accerror));

        return this;
    }

    public LoginObjects loginClick () {
        loginButton.click();

        return this;
    }

    public LoginObjects setEmail (String email) {
        emailInput.setValue(email);

        return this;
    }

    public LoginObjects setBadEmail (String bademail) {
        emailInput.setValue(bademail);

        return this;
    }

    public LoginObjects setPassword (String password) {
        passwordInput.setValue(password);

        return this;
    }

    public LoginObjects goToProfile () {
        profilePage.click();

        return this;
    }

    public LoginObjects checkProfileName (String nickname) {
        nickName.shouldHave(text(nickname));

        return this;
    }
}
