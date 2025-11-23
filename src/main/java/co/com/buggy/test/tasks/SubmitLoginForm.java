package co.com.buggy.test.tasks;

import co.com.buggy.test.interactions.ClickOn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.buggy.test.userinterfaces.HomePage.LOGIN_BUTTON;

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
