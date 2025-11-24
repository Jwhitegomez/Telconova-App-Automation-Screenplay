package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.buggy.test.userinterfaces.ModelPage.MODEL_TITLE;

public class ModelValidation implements Question<String> {
    public static ModelValidation appears() {
        return new ModelValidation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(MODEL_TITLE));
    }
}
