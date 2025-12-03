package co.com.telconova.test.questions;

import co.com.telconova.test.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class LoginAttemptResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.ALERT_MESSAGE).answeredBy(actor).trim();
    }

    public static LoginAttemptResult displayed() {
        return new LoginAttemptResult();
    }
}
