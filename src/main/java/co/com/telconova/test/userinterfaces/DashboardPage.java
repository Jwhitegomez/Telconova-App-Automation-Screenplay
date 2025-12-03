package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage extends PageObject {

    public static final Target WORK_ORDERS_MODULE =
            Target.the("Work orders module")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[1]/button[1]"));

    public static final Target MANUAL_ASSIGNMENT_MODULE =
            Target.the("Manual assignment module")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[1]/button[2]"));

    public static final Target AUTO_ASSIGNMENT_MODULE =
            Target.the("Automatic assignment module")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[1]/button[3]"));

    public static final Target TECHNICIANS_MODULE =
            Target.the("Technicians module")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[1]/button[4]"));

    public static final Target ADMIN_PANEL =
            Target.the("Administrador Panel")
                    .located(By.xpath("/html/body/div/div[2]/header/div/nav/button[2]"));

}
