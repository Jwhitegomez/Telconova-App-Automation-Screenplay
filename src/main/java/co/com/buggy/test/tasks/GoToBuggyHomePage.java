package co.com.buggy.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class GoToBuggyHomePage implements Task {

    private static final String URL = "https://buggy.justtestit.org/";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }

    public static GoToBuggyHomePage goTo() {
        return new GoToBuggyHomePage();
    }
}
