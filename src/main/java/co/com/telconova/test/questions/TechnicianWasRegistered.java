package co.com.telconova.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.htmlunit.xpath.operations.Bool;

import static co.com.telconova.test.userinterfaces.TechniciansModule.TECHNICIANS_LIST;

public class TechnicianWasRegistered implements Question<Boolean> {
    public static TechnicianWasRegistered successfully() {
        return new TechnicianWasRegistered();
    }

    @Override
    public Boolean answeredBy(Actor actor){
        String name = actor.recall("techName");

        String technicianList = actor.asksFor(Text.of(TECHNICIANS_LIST));

        return technicianList.contains(name);
    }
}
