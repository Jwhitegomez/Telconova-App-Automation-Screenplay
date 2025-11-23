package co.com.buggy.test.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterThe implements Interaction {
    private final String text;
    private final Target target;

    public EnterThe(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(text).into(target));
    }

    public static EnterThe wordToWrite(String text, Target target) {
        return Tasks.instrumented(EnterThe.class, text, target);
    }
}