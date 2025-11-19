package co.com.buggy.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class ClickButton implements Task {

    private final String buttonText;

    public ClickButton(String buttonText) {
        this.buttonText = buttonText;
    }

    public static ClickButton withName(String buttonText) {
        return new ClickButton(buttonText);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String xpath = "//a[normalize-space(text())='" + buttonText + "']"
                + " | //button[normalize-space(text())='" + buttonText + "']";

        actor.attemptsTo(
                Click.on(By.xpath(xpath))
        );
    }
}
