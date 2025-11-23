package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.buggy.test.userinterfaces.HomePage.LOGOUT;

public class LoginValidation implements Question<String> {
    public static LoginValidation appears() {
        return new LoginValidation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(LOGOUT));
    }
}
