package pageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import code.Browsers;
import utilities.CommonCode;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class LoginElements extends CommonCode {

	public LoginElements(RemoteWebDriver driver) {
		CommonCode.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 40),this);
	}
	
	@FindBy(xpath=".//*[@id='li_myaccount']/a")
	public WebElement myAccount;
	
	@FindBy(xpath=".//*[@id='li_myaccount']/ul/li/a[text()=' Login']")
	public WebElement loginLink;
	
	@FindBy(xpath=".//*[@id='loginfrm']/div/div[@class='panel-heading']")
	public WebElement loginPanel;
	
	@FindBy(xpath=".//*[@id='loginfrm']//input[@name='username']")
	public WebElement emailTextField;
	
	@FindBy(xpath=".//*[@id='loginfrm']//input[@name='password']")
	public WebElement passwordTextField;
	
	@FindBy(xpath=".//*[@id='loginfrm']//button[@type='submit'][contains(@class,'loginbtn')]")
	public WebElement loginButton;
	
	@FindBy(xpath="html/body//li/a[@data-toggle='dropdown']/i")
	public WebElement logoutDropdown;
	
	@FindBy(xpath=".//div[contains(@class,'navbar')]//ul/ul/li[@class='open']/ul/li/a[contains(@href,'logout')]")
	public WebElement logoutButton;
	
	

}
