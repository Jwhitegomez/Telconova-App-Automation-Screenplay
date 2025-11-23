package co.com.buggy.test.tasks;

import co.com.buggy.test.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class WriteThe implements Task {
    private final String text;
    private final Target target;

    public WriteThe(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.wordToWrite(text, target));
    }

    public static WriteThe text(String text, Target target) {
        return Tasks.instrumented(WriteThe.class, text, target);
    }
}