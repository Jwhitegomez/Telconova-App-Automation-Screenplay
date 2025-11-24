package co.com.buggy.test.stepdefinitions;

import co.com.buggy.test.interactions.ClickOn;
import co.com.buggy.test.interactions.Pause;
import co.com.buggy.test.models.LoginData;
import co.com.buggy.test.questions.*;
import co.com.buggy.test.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;

import static co.com.buggy.test.userinterfaces.ModelPage.COMMENT_BOX;
import static co.com.buggy.test.userinterfaces.ModelPage.COMMENT_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CommentStepDefinition {
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

    @Given("I am on the model page for Lamborghini Veneno")
    public void IAmOnTheModelPageForLamborghiniVeneno() {
        user.attemptsTo(
                GoToCarModelPage.goTo(),
                Pause.forMs(2000)
        );
    }

    @When("I try to leave a comment")
    public void iTryToLeaveAComment() {
        boolean commentBoxVisible = user.asksFor(CommentBoxIs.visible());

        if (commentBoxVisible) {
            user.attemptsTo(
                    Enter.theValue("Automated test comment").into(COMMENT_BOX),
                    Pause.forMs(8000)
            );
        }
    }

    @Then("I should see that I need to be logged in to comment")
    public void iShouldSeeThatINeedToBeLoggedInToComment() {
        user.should(
                seeThat(
                    LoginWarning.text(),
                    equalTo("You need to be logged in to vote.")
                )
        );
    }

    @Given("I log in from the model page")
    public void iLogInFromTheModelPage() {
        LoginData data = new LoginData(
                "jwhite.gomez4",
                "Password123@"
        );

        user.attemptsTo(
                ProvideLoginCredentials.with(data),
                Pause.forMs(1000),
                SubmitLoginForm.now(),
                Pause.forMs(8000)
        );
    }

    @When("I leave a comment.")
    public void iLeaveAComment() {
        String comment = "ComentarioPrueba321";

        user.remember("lastComment", comment);
        user.attemptsTo(
                Enter.theValue(comment).into(COMMENT_BOX),
                ClickOn.button(COMMENT_BUTTON),
                Pause.forMs(9000)
        );
    }

    @Then("I should see the posted comment.")
    public void iShouldSeeThePostedComment() {
        user.should(
                seeThat(CommentWasPosted.successfully(), equalTo(true))
        );
    }
}
