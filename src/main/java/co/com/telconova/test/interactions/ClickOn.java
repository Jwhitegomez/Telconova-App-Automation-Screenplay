package co.com.telconova.test.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOn implements Interaction {
    private final Target target;

    public ClickOn(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
    }

    public static ClickOn button(Target target) {
        return Tasks.instrumented(ClickOn.class, target);
    }

    public static ClickOn section(Target target) {
        return Tasks.instrumented(ClickOn.class, target);
    }

    public static ClickOn item(Target target) {
        return Tasks.instrumented(ClickOn.class, target);
    }
}
