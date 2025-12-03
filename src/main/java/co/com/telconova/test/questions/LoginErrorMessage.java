package co.com.telconova.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.telconova.test.userinterfaces.HomePage.LOGIN_FAILURE_MESSAGE;
import net.serenitybdd.screenplay.questions.Text;

public class LoginErrorMessage implements Question<String> {

    public static LoginErrorMessage appears() {
        return new LoginErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(LOGIN_FAILURE_MESSAGE));
    }
}
