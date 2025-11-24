package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.ClickOn;
import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.questions.ModelValidation;
import co.com.buggy.test.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.buggy.test.userinterfaces.CarsModelListPage.LAMBORGHINI_VENENO;
import static co.com.buggy.test.userinterfaces.HomePage.MODELS_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class SelectCarStepDefinition {
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

    @Given("I am on the Buggy Rating home page")
    public void iAmOnTheBuggyRatingHomePage() {
        user.attemptsTo(
                GoToBuggyHomePage.goTo(),
                Pause.forMs(3000)
        );
    }

    @When("I navigate to the vehicles list")
    public void iNavigateToTheVehiclesList() {
        user.attemptsTo(
                ClickOn.section(MODELS_LIST),
                Pause.forMs(6000)
        );
    }

    @And("I select the Lamborghini Veneno model")
    public void iSelectTheLamborghiniVenenoModel() {
        user.attemptsTo(
                ClickOn.section(LAMBORGHINI_VENENO),
                Pause.forMs(3000)
        );
    }

    @Then("I should see the model page for Lamborghini Veneno")
    public void iShouldSeeTheModelPageForLamborghiniVeneno() {
        user.should(
                seeThat(ModelValidation.appears(), containsString("Veneno"))
        );
    }
}
