package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.buggy.test.userinterfaces.RegistrationPage.REGISTRATION_FAILURE_MESSAGE;

public class RegistrationErrorMessage implements Question<String> {

    public static RegistrationErrorMessage appears() {
        return new RegistrationErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(net.serenitybdd.screenplay.questions.Text.of(REGISTRATION_FAILURE_MESSAGE));
    }
}
