package co.com.buggy.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;

public class ProvideRegistrationCredentials implements Task {

    public static ProvideRegistrationCredentials completely() {
        return new ProvideRegistrationCredentials();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                // Username
                Enter.theValue("jimmy1234").into(By.id("username")),
                Pause.forMs(500),

                // First Name
                Enter.theValue("Jimmy").into(By.id("firstName")),
                Pause.forMs(500),

                // Last Name
                Enter.theValue("Gomez").into(By.id("lastName")),
                Pause.forMs(500),

                // Password
                Enter.theValue("Password123@").into(By.id("password")),
                Pause.forMs(500),

                // Confirm Password
                Enter.theValue("Password123@").into(By.id("confirmPassword")),
                Pause.forMs(500)
        );
    }
}
