package co.com.telconova.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.telconova.test.userinterfaces.WorkOrdersModule.ASSIGN_CONFIRMATION;

public class WorkOrderWasAssigned implements Question<Boolean> {

    public static WorkOrderWasAssigned successfully(){
        return new WorkOrderWasAssigned();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String assigned = actor.asksFor(Text.of(ASSIGN_CONFIRMATION));

        return assigned.contains("Asignada");
    }
}
