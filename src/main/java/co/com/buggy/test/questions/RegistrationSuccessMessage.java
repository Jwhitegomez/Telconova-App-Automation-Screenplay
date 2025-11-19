package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class RegistrationSuccessMessage implements Question<Boolean> {
    private static final By SUCCESS_MESSAGE =
            By.xpath("//form//div[contains(text(), 'Registration')]");

    public static RegistrationSuccessMessage appears() {
        return new RegistrationSuccessMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String message = actor.asksFor(
                    net.serenitybdd.screenplay.questions.WebElementQuestion.the(SUCCESS_MESSAGE)
            ).getText();

            return message.contains("Registration is successful");

        } catch (Exception e) {
            return false;
        }
    }
}
