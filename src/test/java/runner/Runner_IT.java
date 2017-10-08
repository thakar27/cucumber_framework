package runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/FileReadWrite.feature", glue = "steps_Definition", tags = "@Read", strict = false, plugin = {
		"com.github.kirlionik.cucumberallure.AllureReporter", "pretty",
		"json:target/Cucumber.json", "html:target/cucumber-html-report" })
public class Runner_IT {

	/**
	 * Add information into block "Environment". Create allure property file in
	 * target/allure-results
	 */
	@BeforeClass
	public static void create_Allure_properties() {
		String source_location = "";
		try {
			source_location = new File(".").getCanonicalPath();
		} catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(source_location);
		final File source = new File(source_location + "\\environment.xml");
		final File dest = new File(source_location
				+ "\\target\\allure-results\\");
		try {
			FileUtils.copyFileToDirectory(source, dest);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
