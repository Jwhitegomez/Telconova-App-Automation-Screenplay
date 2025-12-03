package co.com.telconova.test.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrationPage extends PageObject {

    public static final Target REGISTER_TECHNICIAN =
            Target.the("Register technician section")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[1]/button[2]"));

    public static final Target NAME = Target.the("Name field").located(By.id("techName"));
    public static final Target EMAIL = Target.the("Email field").located(By.id("techEmail"));
    public static final Target PHONE = Target.the("Phone field").located(By.id("techPhone"));
    public static final Target SPECIALTY = Target.the("Specialty field").located(By.id("techSpecialty"));
    public static final Target ZONE = Target.the("Zone field").located(By.id("techZone"));

    public static final Target SELECT_SPECIALTY =
            Target.the("Select specialty")
                    .locatedBy("//div[contains(@class,'radix') or @role='option'][normalize-space()='{0}']");

    public static final Target SELECT_ZONE =
            Target.the("Select zone")
                    .locatedBy("//div[contains(@class,'radix') or @role='option'][normalize-space()='{0}']");

    public static final Target REGISTER_SUBMIT_BUTTON =
            Target.the("Register submit button")
                    .located(By.xpath("/html/body/div/div[2]/main/div/div[3]/div/div[2]/form/button"));

    public static final Target DASHBOARD =
            Target.the("Dashboard button")
                    .located(By.xpath("/html/body/div/div[2]/header/div/button"));

}
