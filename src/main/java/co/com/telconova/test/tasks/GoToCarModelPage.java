package co.com.telconova.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class GoToCarModelPage implements Task {

    private static final String URL = "https://buggy.justtestit.org/model/ckl2phsabijs71623vk0%7Cckl2phsabijs71623vng";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }

    public static GoToCarModelPage goTo() {
        return new GoToCarModelPage();
    }
}
