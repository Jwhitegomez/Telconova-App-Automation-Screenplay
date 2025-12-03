package co.com.telconova.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.telconova.test.userinterfaces.ModelPage.COMMENTS_CONTAINER;

public class CommentWasPosted implements Question<Boolean> {

    public static CommentWasPosted successfully(){
        return new CommentWasPosted();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String comment = actor.recall("lastComment");

        String commentsText = actor.asksFor(Text.of(COMMENTS_CONTAINER));

        return commentsText.contains(comment);
    }
}
