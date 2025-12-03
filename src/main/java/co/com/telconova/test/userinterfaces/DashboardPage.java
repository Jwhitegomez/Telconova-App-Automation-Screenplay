package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage extends PageObject {

    public static final Target WORK_ORDERS_MODULE =
            Target.the("Work orders module")
                    .located(By.xpath("//*[@id=\"radix-:r0:-trigger-orders\"]"));

    public static final Target MANUAL_ASSIGNMENT_MODULE =
            Target.the("Manual assignment module")
                    .located(By.xpath("//*[@id=\"radix-:r0:-trigger-manual\"]"));

    public static final Target AUTO_ASSIGNMENT_MODULE =
            Target.the("Automatic assignment module")
                    .located(By.xpath("//*[@id=\"radix-:r0:-trigger-automatic\"]"));

    public static final Target TECHNICIANS_MODULE =
            Target.the("Technicians module")
                    .located(By.xpath("//*[@id=\"radix-:r0:-trigger-technicians\"]"));

}
