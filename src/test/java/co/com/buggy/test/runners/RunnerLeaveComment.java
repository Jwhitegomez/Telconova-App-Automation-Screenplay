package co.com.buggy.test.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/04_leave_a_comment.feature",
        glue = "co.com.buggy.test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerLeaveComment {}
