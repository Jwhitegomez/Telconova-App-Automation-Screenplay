package co.com.telconova.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class GoToTelconovaHomePage implements Task {

    private static final String URL = "https://telconova-dispatch-dash.lovable.app/login";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }

    public static GoToTelconovaHomePage goTo() {
        return new GoToTelconovaHomePage();
    }
}
