package co.com.buggy.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class Pause implements Task {
    private final long millis;

    public Pause(long millis) {
        this.millis = millis;
    }

    public static Pause forMs(long millis) {
        return new Pause(millis);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
