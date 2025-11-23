package co.com.buggy.test.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrationPage extends PageObject {

    public static final Target USERNAME = Target.the("Username field").located(By.id("username"));
    public static final Target FIRST_NAME = Target.the("First name field").located(By.id("firstName"));
    public static final Target LAST_NAME = Target.the("Last name field").located(By.id("lastName"));
    public static final Target PASSWORD = Target.the("Password field").located(By.id("password"));
    public static final Target CONFIRM_PASSWORD = Target.the("Confirm password field").located(By.id("confirmPassword"));

    public static final Target REGISTER_SUBMIT_BUTTON =
            Target.the("Register submit button")
                    .located(By.xpath("//my-register//form//button[contains(text(),'Register')]"));

    public static final Target REGISTRATION_SUCCESS_MESSAGE =
            Target.the("Success registration message")
                    .located(By.xpath("//form//div[contains(text(), 'Registration')]"));

    public static final Target REGISTRATION_FAILURE_MESSAGE =
            Target.the("Failure registration message")
                    .located(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/div[6]"));

}
