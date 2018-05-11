package cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"step_definitions"}
		//,dryRun=true
		)
public class TestRunner {
	
}

//options: manually re-write

	


