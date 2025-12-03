package co.com.telconova.test.stepdefinitions;

import co.com.telconova.test.interactions.ClickOn;
import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.questions.WorkOrderWasAssigned;
import co.com.telconova.test.tasks.GoToDashboard;
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

import static co.com.telconova.test.userinterfaces.AutoAssignmentModule.ASSIGN_AUTOMATICALLY;
import static co.com.telconova.test.userinterfaces.AutoAssignmentModule.ORDER;
import static co.com.telconova.test.userinterfaces.DashboardPage.AUTO_ASSIGNMENT_MODULE;
import static co.com.telconova.test.userinterfaces.DashboardPage.WORK_ORDERS_MODULE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AutomaticAssignmentStepDefinition {
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

    @Given("I am in the dashboard module")
    public void iAmInTheDashboardModule() {
        user.attemptsTo(GoToDashboard.now());
    }

    @And("I go to automatic assignment module")
    public void iGoToAutomaticAssignmentModule() {
        user.attemptsTo(
                ClickOn.section(AUTO_ASSIGNMENT_MODULE),
                Pause.forMs(1500)
        );
    }

    @When("I select a work order from the list")
    public void iSelectAWorkOrderFromTheList() {
        user.attemptsTo(
                ClickOn.item(ORDER),
                Pause.forMs(1500)
        );
    }

    @And("I assign automatically the work order")
    public void iAssignAutomaticallyTheWorkOrder() {
        user.attemptsTo(
                ClickOn.button(ASSIGN_AUTOMATICALLY),
                Pause.forMs(4000)
        );
    }

    @Then("I should confirm that the work order was assigned automatically")
    public void iShouldConfirmThatTheWorkOrderWasAssignedAutomatically() {
        user.attemptsTo(
                ClickOn.section(WORK_ORDERS_MODULE),
                Pause.forMs(4000)
        );

        user.should(seeThat(WorkOrderWasAssigned.successfully(), equalTo(true)));
    }
}
