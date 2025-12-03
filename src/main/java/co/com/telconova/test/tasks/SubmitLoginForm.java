package co.com.telconova.test.tasks;

import co.com.telconova.test.interactions.ClickOn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.telconova.test.userinterfaces.HomePage.LOGIN_BUTTON;

public class SubmitLoginForm implements Task {
    public static SubmitLoginForm now() {
        return new SubmitLoginForm();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.button(LOGIN_BUTTON)
        );
    }
}
