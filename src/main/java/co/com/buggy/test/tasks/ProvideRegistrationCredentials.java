package co.com.buggy.test.tasks;

import co.com.buggy.test.models.RegistrationData;
import co.com.buggy.test.userinterfaces.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class ProvideRegistrationCredentials implements Task {

    private final RegistrationData data;

    public ProvideRegistrationCredentials(RegistrationData data) {
        this.data = data;
    }

    public static ProvideRegistrationCredentials with(RegistrationData data) {
        return new ProvideRegistrationCredentials(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(data.getUsername()).into(RegistrationPage.USERNAME),
                Enter.theValue(data.getFirstName()).into(RegistrationPage.FIRST_NAME),
                Enter.theValue(data.getLastName()).into(RegistrationPage.LAST_NAME),
                Enter.theValue(data.getPassword()).into(RegistrationPage.PASSWORD),
                Enter.theValue(data.getConfirmPassword()).into(RegistrationPage.CONFIRM_PASSWORD)
        );
    }
}
