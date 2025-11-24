package co.com.buggy.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.buggy.test.userinterfaces.ModelPage.COMMENT_BOX;

public class CommentBoxIs implements Question<Boolean> {

    public static CommentBoxIs visible() {
        return new CommentBoxIs();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return COMMENT_BOX.resolveFor(actor).isVisible();
    }
}
