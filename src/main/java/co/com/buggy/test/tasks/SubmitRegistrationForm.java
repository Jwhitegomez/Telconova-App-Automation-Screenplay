package co.com.buggy.test.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class SubmitRegistrationForm implements Task {

    private static final By REGISTER_SUBMIT_BUTTON =
            By.xpath("//my-register//form//button[contains(text(),'Register')]");

    public static SubmitRegistrationForm now() {
        return new SubmitRegistrationForm();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(REGISTER_SUBMIT_BUTTON)
        );
    }
}