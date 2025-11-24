package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.buggy.test.userinterfaces.ModelPage.LOGIN_WARNING;

public class LoginWarning implements Question<String> {
    public static LoginWarning text() {
        return new LoginWarning();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LOGIN_WARNING.resolveFor(actor).getText();
    }
}
