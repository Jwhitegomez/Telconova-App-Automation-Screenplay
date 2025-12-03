package co.com.telconova.test.stepdefinitions;

import co.com.telconova.test.interactions.Pause;
import co.com.telconova.test.models.LoginData;
import co.com.telconova.test.questions.LoginAttemptResult;
import co.com.telconova.test.questions.LoginErrorMessage;
import co.com.telconova.test.questions.LoginValidation;
import co.com.telconova.test.tasks.GoToTelconovaHomePage;
import co.com.telconova.test.tasks.ProvideLoginCredentials;
import co.com.telconova.test.tasks.SubmitLoginForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinition {

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

    @Given("I am in the home page")
    public void iAmInTheHomePage() {
        user.attemptsTo(
                GoToTelconovaHomePage.goTo(),
                Pause.forMs(3000)
        );
    }

    @When("I enter login credentials:")
    public void iEnterLoginCredentials(Map<String, String> data) {

        LoginData loginData = new LoginData(
                data.get("username"),
                data.get("password")
        );

        user.attemptsTo(
                ProvideLoginCredentials.with(loginData)
        );
    }

    @And("I submit the login form")
    public void iSubmitTheLoginForm() {
        user.attemptsTo(
                SubmitLoginForm.now(),
                Pause.forMs(3000)
        );
    }

    @Then("I should see {string}")
    public void iShouldSee(String expected) {

        if (expected.equals("Inicio de sesión exitoso")) {
            user.should(seeThat(LoginValidation.appears(), containsString("Cerrar Sesión")));
        } else {
            user.should(seeThat(LoginErrorMessage.appears(), containsString(expected)));
        }
    }

    @When("I try to login with wrong credentials three times in a row with:")
    public void iTryToLoginWithWrongCredentialsThreeTimesInARowWith(Map<String, String> data) {
        LoginData loginData = new LoginData(
                data.get("username"),
                data.get("password")
        );

        user.attemptsTo(
                ProvideLoginCredentials.with(loginData),
                SubmitLoginForm.now(),
                Pause.forMs(3000),
                ProvideLoginCredentials.with(loginData),
                SubmitLoginForm.now(),
                Pause.forMs(3000),
                ProvideLoginCredentials.with(loginData),
                SubmitLoginForm.now(),
                Pause.forMs(6000)
        );
    }

    @Then("I should see {string} blocking message")
    public void iShouldSeeBlockingMessage(String expected) {
        user.should(seeThat(LoginAttemptResult.displayed(), containsString(expected)));
    }
}
