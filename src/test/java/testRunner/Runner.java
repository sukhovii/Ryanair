package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

public class Runner {

    public static void main(String[] args) throws Throwable {
        String[] arguments = {"--glue", "StepDefinition", "classpath:features/creditCard.feature", "--plugin","pretty","--plugin","html:./target/cucumber-reports"};
        cucumber.api.cli.Main.main(arguments);
    }
}
