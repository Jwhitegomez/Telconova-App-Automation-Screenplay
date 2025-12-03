package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ManualAssignmentModule {
    public static final Target ORDER =
            Target.the("Work order")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[3]/div/div[1]/div[2]/div/div/div[1]"));

    public static final Target TECHNICIAN =
            Target.the("Technician")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[3]/div/div[2]/div[2]/div/div[2]/div[1]"));

    public static final Target ASSIGN_TECHNICIAN =
            Target.the("Assign Technician button")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[3]/div/div[2]/div[2]/div/button"));

}
