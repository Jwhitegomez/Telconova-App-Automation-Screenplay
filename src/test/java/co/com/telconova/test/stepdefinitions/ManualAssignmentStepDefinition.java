package co.com.telconova.test.stepdefinitions;

import co.com.telconova.test.interactions.ClickOn;
import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.questions.WorkOrderWasAssigned;
import co.com.telconova.test.tasks.GoToTelconovaHomePage;
import co.com.telconova.test.tasks.ProvideLoginCredentials;
import co.com.telconova.test.tasks.SubmitLoginForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.telconova.test.userinterfaces.DashboardPage.MANUAL_ASSIGNMENT_MODULE;
import static co.com.telconova.test.userinterfaces.DashboardPage.WORK_ORDERS_MODULE;
import static co.com.telconova.test.userinterfaces.ManualAssignmentModule.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ManualAssignmentStepDefinition {

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

    @Given("I am in the dashboard")
    public void iAmInTheDashboard() {
        LoginData data = new LoginData(
                "supervisor_test",
                "password123"
        );

        user.attemptsTo(
                GoToTelconovaHomePage.goTo(),
                Pause.forMs(2000),
                ProvideLoginCredentials.with(data),
                Pause.forMs(1000),
                SubmitLoginForm.now(),
                Pause.forMs(4000)
        );
    }

    @And("I go to manual assignment module")
    public void iGoToManualAssignmentModule() {
        user.attemptsTo(
                ClickOn.section(MANUAL_ASSIGNMENT_MODULE),
                Pause.forMs(1500)
        );
    }

    @When("I select a technician from the list")
    public void iSelectATechnicianFromTheList() {
        user.attemptsTo(
                ClickOn.item(TECHNICIAN),
                Pause.forMs(1500)
        );
    }

    @And("I assign the technician to a work order")
    public void iAssignTheTechnicianToAWorkOrder() {
        user.attemptsTo(
                ClickOn.item(ORDER),
                Pause.forMs(1500),
                ClickOn.button(ASSIGN_TECHNICIAN),
                Pause.forMs(3000)
        );
    }

    @Then("I should confirm that the work order was assigned")
    public void iShouldConfirmThatTheWorkOrderWasAssigned() {
        user.attemptsTo(
                ClickOn.section(WORK_ORDERS_MODULE),
                Pause.forMs(4000)
        );

        user.should(seeThat(WorkOrderWasAssigned.successfully(), equalTo(true)));
    }
}
