package co.com.telconova.test.tasks;

import co.com.telconova.test.interactions.ClickOn;
import co.com.telconova.test.models.RegistrationData;
import co.com.telconova.test.userinterfaces.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.telconova.test.userinterfaces.RegistrationPage.*;

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
                Enter.theValue(data.getName()).into(RegistrationPage.NAME),
                Enter.theValue(data.getEmail()).into(RegistrationPage.EMAIL),
                Enter.theValue(data.getPhone()).into(RegistrationPage.PHONE),
                ClickOn.section(SPECIALTY),
                ClickOn.item(SELECT_SPECIALTY.of("Mantenimiento")),
                ClickOn.section(ZONE),
                ClickOn.item(SELECT_ZONE.of("Centro"))
        );
    }
}
