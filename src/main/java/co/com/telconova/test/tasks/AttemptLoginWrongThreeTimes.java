package co.com.telconova.test.tasks;

import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.tasks.ProvideLoginCredentials;
import co.com.telconova.test.tasks.SubmitLoginForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AttemptLoginWrongThreeTimes implements Task {

    private final LoginData loginData;

    public AttemptLoginWrongThreeTimes(Integer attempts, LoginData loginData) {
        this.loginData = loginData;
    }

    public static AttemptLoginWrongThreeTimes with(Integer attempts, LoginData loginData) {
        return Tasks.instrumented(AttemptLoginWrongThreeTimes.class, loginData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < 3; i++) {
            actor.attemptsTo(
                    ProvideLoginCredentials.with(loginData),
                    SubmitLoginForm.now(),
                    Pause.forMs(1000)
            );
        }
    }
}

