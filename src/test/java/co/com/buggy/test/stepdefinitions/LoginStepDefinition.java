package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.models.LoginData;
import co.com.buggy.test.questions.LoginErrorMessage;
import co.com.buggy.test.questions.LoginValidation;
import co.com.buggy.test.tasks.*;
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
                GoToBuggyHomePage.goTo(),
                Pause.forMs(4000)
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
                Pause.forMs(6000)
        );
    }

    @Then("I should see {string}")
    public void iShouldSee(String expected) {

        if (expected.equals("Login successful")) {
            user.should(seeThat(LoginValidation.appears(), containsString("Logout")));
        } else {
            user.should(seeThat(LoginErrorMessage.appears(), containsString(expected)));
        }
    }
}
