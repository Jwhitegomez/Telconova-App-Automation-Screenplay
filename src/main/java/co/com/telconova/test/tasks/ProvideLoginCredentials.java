package co.com.telconova.test.tasks;

import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class ProvideLoginCredentials implements Task {

    private final LoginData data;

    public ProvideLoginCredentials(LoginData data) {
        this.data = data;
    }

    public static ProvideLoginCredentials with(LoginData data) {
        return new ProvideLoginCredentials(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.getUsername()).into(HomePage.USERNAME),
                Enter.theValue(data.getPassword()).into(HomePage.PASSWORD)
        );
    }
}
