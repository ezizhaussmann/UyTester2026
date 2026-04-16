package men.programmer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = "men.programmer",
    plugin = {"pretty"},
    monochrome = true
)
public class RunCucumberTest {
}
