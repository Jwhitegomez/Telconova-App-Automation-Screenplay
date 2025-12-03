package co.com.telconova.test.tasks;

import co.com.telconova.test.userinterfaces.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SubmitRegistrationForm implements Task {

    public static SubmitRegistrationForm now() {
        return new SubmitRegistrationForm();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegistrationPage.REGISTER_SUBMIT_BUTTON)
        );
    }
}