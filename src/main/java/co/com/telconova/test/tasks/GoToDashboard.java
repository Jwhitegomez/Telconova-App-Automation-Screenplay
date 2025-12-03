package co.com.telconova.test.tasks;

import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class GoToDashboard implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoginData data = new LoginData(
                "supervisor_test",
                "password123"
        );

        actor.attemptsTo(
                GoToTelconovaHomePage.goTo(),
                Pause.forMs(2000),
                ProvideLoginCredentials.with(data),
                Pause.forMs(1000),
                SubmitLoginForm.now(),
                Pause.forMs(4000)
        );
    }

    public static GoToDashboard now() {
        return new GoToDashboard();
    }
}
