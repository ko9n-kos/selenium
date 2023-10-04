package onliner.test;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/onliner/features/OnlinerFeature.feature", glue = "src/test/java/onliner/stepsDefinition")

public class RunnerTest {
}