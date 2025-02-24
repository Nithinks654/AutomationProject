import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //for providing path for features which we have to run
        glue = "org/nithin/testing/stepdefinition", //for providing stepDefination path
        plugin = {"pretty","json:target/cucumber-reports.json","html:target/cucumber-reports.html","junit:target/cucumber-reports.xml"},
//        tags = "@getTest", // to control what scenarios to run
        monochrome= true // to showcase reports neatly
)
public class TestRunner {
}