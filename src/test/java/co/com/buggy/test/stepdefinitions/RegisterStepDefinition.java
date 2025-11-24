package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.ClickOn;
import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.models.RegistrationData;
import co.com.buggy.test.questions.RegistrationErrorMessage;
import co.com.buggy.test.questions.RegistrationSuccessMessage;
import co.com.buggy.test.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static co.com.buggy.test.userinterfaces.HomePage.REGISTER_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDefinition {

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

    @Given("I am in the Buggy Rating home page")
    public void iAmInTheBuggyRatingHomePage() {
        user.attemptsTo(
                GoToBuggyHomePage.goTo(),
                Pause.forMs(3000)
        );
    }

    @When("I choose to create a new account")
    public void iChooseToCreateANewAccount() {
        user.attemptsTo(
                ClickOn.button(REGISTER_BUTTON),
                Pause.forMs(3000)
        );
    }

    @When("I enter the registration data:")
    public void iEnterTheRegistrationData(Map<String, String> dataTable) {

        RegistrationData data = new RegistrationData(
                dataTable.get("username"),
                dataTable.get("firstName"),
                dataTable.get("lastName"),
                dataTable.get("password"),
                dataTable.get("password")
        );

        user.attemptsTo(
                ProvideRegistrationCredentials.with(data)
        );
    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        user.attemptsTo(
                SubmitRegistrationForm.now(),
                Pause.forMs(6000)
        );
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {

        if (expectedMessage.equals("Account created")) {
            user.should(seeThat(RegistrationSuccessMessage.appears(), equalTo(true)));
        } else {
            user.should(seeThat(RegistrationErrorMessage.appears(), containsString(expectedMessage)));
        }
    }
}
