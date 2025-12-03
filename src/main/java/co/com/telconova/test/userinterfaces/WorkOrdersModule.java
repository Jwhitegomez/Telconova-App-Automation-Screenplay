package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class WorkOrdersModule extends PageObject {

    public static final Target ASSIGN_CONFIRMATION =
            Target.the("Assignment confirmation label")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/div[2]"));
}
