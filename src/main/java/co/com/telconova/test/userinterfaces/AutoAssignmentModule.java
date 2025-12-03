package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AutoAssignmentModule extends PageObject {

    public static final Target ORDER =
            Target.the("Work order")
                    .located(By.xpath("//*[@id=\"radix-:r0:-content-automatic\"]/div/div[2]/div[2]/div/div/div[1]"));

    public static final Target ASSIGN_AUTOMATICALLY =
            Target.the("Assign work order button")
                    .located(By.xpath("//*[@id=\"radix-:r0:-content-automatic\"]/div/div[2]/div[2]/div/button"));

}
