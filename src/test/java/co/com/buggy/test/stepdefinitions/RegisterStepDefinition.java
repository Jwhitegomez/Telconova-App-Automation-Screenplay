package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.ClickOn;
import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.models.RegistrationData;
import co.com.buggy.test.questions.RegistrationErrorMessage;
import co.com.buggy.test.questions.RegistrationSuccessMessage;
import co.com.buggy.test.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

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
                GoToBuggyHomePage.goTo()
        );
    }

    @When("I choose to create a new account")
    public void iChooseToCreateANewAccount() {
        user.attemptsTo(
                Pause.forMs(2000),
                ClickOn.button(REGISTER_BUTTON),
                Pause.forMs(2000)
        );
    }

    @When("I provide valid registration credentials")
    public void iProvideValidRegistrationCredentials() {
        RegistrationData data = new RegistrationData(
                "jimmy.gomez432132",
                "Jimmy",
                "Gomez",
                "Password123@",
                "Password123@"
        );

        user.attemptsTo(
                ProvideRegistrationCredentials.with(data)
        );
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        user.attemptsTo(
                SubmitRegistrationForm.now(),
                Pause.forMs(5000)
        );
    }

    @Then("I should confirm that the account was created")
    public void iShouldConfirmThatTheAccountWasCreated() {
        user.should(seeThat(RegistrationSuccessMessage.appears(), equalTo(true)));
    }

    @When("I provide registration credentials for an already registered user")
    public void iProvideRegistrationCredentialsForAnAlreadyRegisteredUser() {
        RegistrationData data = new RegistrationData(
                "jimmy.gomez",
                "Jimmy",
                "Gomez",
                "Password123@",
                "Password123@"
        );

        user.attemptsTo(
                ProvideRegistrationCredentials.with(data)
        );
    }

    @Then("I should see a message indicating that the username is already taken")
    public void iShouldSeeAMessageIndicatingThatTheUsernameIsAlreadyTaken() {
        user.should(seeThat(RegistrationErrorMessage.appears(),
                containsString("UsernameExistsException: User already exists")));
    }
}
