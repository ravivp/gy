package jt.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ="src/test/java/jt/features/",
        glue ={"jt.steps","jt.Hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        publish = true,

        dryRun = false
       // tags = "@SanityTest"
)
public class TestRunner {



}
