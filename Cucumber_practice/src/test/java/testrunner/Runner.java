package testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/practice.feature", tags="@practice1",
		glue={"stepdefinitions"},
plugin={"pretty", "html:target/htmlReports/index.html"}, monochrome=true)
public class Runner {
	
}
