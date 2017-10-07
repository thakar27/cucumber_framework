package code;

import org.openqa.selenium.remote.RemoteWebDriver;

import pageFactory.LoginElements;
import utilities.CommonCode;

public class Login extends CommonCode {

	public Login(RemoteWebDriver driver) {
		CommonCode.driver = driver;
	}

	LoginElements loginElements = new LoginElements(driver);
	String aut = getConfigForproperty("aut");
	String username = getConfigForproperty("username");
	String password = getConfigForproperty("password");

	public void openWebApplication() {
		driver.get(aut);
	}

	public void clickMyAccount() {
		waitForPageFactory(loginElements.myAccount, driver).click();
	}

	public void enterCredentials() {
		loginElements.emailTextField.sendKeys(username);
		loginElements.passwordTextField.sendKeys(password);

	}

}
