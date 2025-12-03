package co.com.telconova.test.tasks;

import co.com.telconova.test.interactions.ClickOn;
import co.com.telconova.test.interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.telconova.test.userinterfaces.ManualAssignmentModule.ASSIGN_TECHNICIAN;
import static co.com.telconova.test.userinterfaces.ManualAssignmentModule.ORDER;

public class Assign implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.item(ORDER),
                Pause.forMs(1500),
                ClickOn.button(ASSIGN_TECHNICIAN),
                Pause.forMs(3000)
        );
    }

    public static Assign technician() {
        return new Assign();
    }
}
