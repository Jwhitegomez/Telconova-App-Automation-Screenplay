package co.com.telconova.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.telconova.test.userinterfaces.RegistrationPage.REGISTRATION_SUCCESS_MESSAGE;

public class RegistrationSuccessMessage implements Question<Boolean> {

    public static RegistrationSuccessMessage appears() {
        return new RegistrationSuccessMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String message = actor.asksFor(
                    net.serenitybdd.screenplay.questions.WebElementQuestion.the(REGISTRATION_SUCCESS_MESSAGE)
            ).getText();

            return message.contains("Registration is successful");

        } catch (Exception e) {
            return false;
        }
    }
}
