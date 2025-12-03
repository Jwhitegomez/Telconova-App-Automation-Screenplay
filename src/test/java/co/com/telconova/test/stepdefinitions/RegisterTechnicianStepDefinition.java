package co.com.telconova.test.stepdefinitions;

import co.com.telconova.test.interactions.ClickOn;
import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.models.RegistrationData;
import co.com.telconova.test.questions.TechnicianWasRegistered;
import co.com.telconova.test.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static co.com.telconova.test.userinterfaces.DashboardPage.*;
import static co.com.telconova.test.userinterfaces.RegistrationPage.DASHBOARD;
import static co.com.telconova.test.userinterfaces.RegistrationPage.REGISTER_TECHNICIAN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterTechnicianStepDefinition {
    protected static Actor user;

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    @Before
    public void setUp() {
        if (user == null) {
            user = Actor.named("Jimmy");
            user.can(BrowseTheWeb.with(theDriver));
        }
    }

    @Given("I am in the admin dashboard")
    public void iAmInTheAdminDashboard() {
        LoginData data = new LoginData(
                "admin_demo",
                "admin123"
        );

        user.attemptsTo(
                GoToTelconovaHomePage.goTo(),
                Pause.forMs(2000),
                ProvideLoginCredentials.with(data),
                Pause.forMs(1000),
                SubmitLoginForm.now(),
                Pause.forMs(3000)
        );
    }

    @And("I navigate to register a new technician")
    public void iNavigateToRegisterANewTechnician() {
        user.attemptsTo(
                ClickOn.section(ADMIN_PANEL),
                Pause.forMs(1500),
                ClickOn.section(REGISTER_TECHNICIAN),
                Pause.forMs(2000)
        );
    }

    @When("I fill the form with information:")
    public void iFillTheFormWithInformation(Map<String, String> data) {
        RegistrationData registerData = new RegistrationData(
                data.get("name"),
                data.get("email"),
                data.get("phone")
        );

        user.remember("techName", data.get("name"));
        user.attemptsTo(
                ProvideRegistrationCredentials.with(registerData),
                Pause.forMs(3000)
        );
    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        user.attemptsTo(
                SubmitRegistrationForm.now(),
                Pause.forMs(3000)
        );
    }

    @Then("I should confirm that technician was registered")
    public void iShouldConfirmThatTechnicianWasRegistered() {
        user.attemptsTo(
                ClickOn.button(DASHBOARD),
                Pause.forMs(1500),
                ClickOn.section(TECHNICIANS_MODULE),
                Pause.forMs(4000)
        );

        user.should(seeThat(TechnicianWasRegistered.successfully(), equalTo(true)));
    }
}
