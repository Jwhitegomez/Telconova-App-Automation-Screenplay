package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.models.LoginData;
import co.com.buggy.test.questions.LoginErrorMessage;
import co.com.buggy.test.questions.LoginValidation;
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

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        LoginData data = new LoginData(
                "jwhite.gomez4",
                "Password123@"
        );

        user.attemptsTo(ProvideLoginCredentials.with(data));
    }

    @When("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        LoginData data = new LoginData(
                "jwhite.gomez4",
                "Password123"
        );

        user.attemptsTo(ProvideLoginCredentials.with(data));
    }

    @And("I submit the login form")
    public void iSubmitTheLoginForm() {
        user.attemptsTo(
                SubmitLoginForm.now(),
                Pause.forMs(6000)
        );
    }

    @Then("I should see that I have logged in successfully")
    public void iShouldSeeThatIHaveLoggedInSuccessfully() {
        user.should(seeThat(LoginValidation.appears(), containsString("Logout")));
    }

    @Then("I should see an error message indicating that the login failed")
    public void iShouldSeeAnErrorMessageIndicatingThatTheLoginFailed() {
        user.should(seeThat(LoginErrorMessage.appears(), containsString("Invalid username/password")));
    }
}
