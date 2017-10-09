package steps_Definition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.CommonCode;
import code.Browsers;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonCode {/*

	private static final String BROWSER_PROP_KEY = "browser";

	static DesiredCapabilities capabilities = new DesiredCapabilities();
	static String hubURL = getConfigForproperty("hubURL");
	static String nodeURL = getConfigForproperty("aut");

	@Before
	public void getBrowser() throws MalformedURLException {

		Browsers browser;
		if (System.getProperty(BROWSER_PROP_KEY) == null) {
			browser = Browsers.CHROME;
		} else {
			browser = Browsers.browserForName(System
					.getProperty(BROWSER_PROP_KEY));
		}
		switch (browser) {
		case CHROME:
			System.getProperty("user.home");
			capabilities = DesiredCapabilities.chrome();
			final ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			options.addArguments("-disable-cache");
			options.addArguments("--enable-save-password-bubble=true");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;
		case IE:
			capabilities = DesiredCapabilities.internetExplorer();
			try {
				driver = new RemoteWebDriver(new URL(hubURL), capabilities);
				System.out.println("");
			} catch (final MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.manage().window().maximize();

		default:

			System.out.println("executed");
			break;
		}
	}

	@After
	public void close() {
		driver.quit();
	}

*/}
