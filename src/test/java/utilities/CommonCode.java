package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;

public class CommonCode {


	public static RemoteWebDriver driver;
	public static RemoteWebDriver elasticSearchDriver;
	public static RemoteWebDriver visitordriver;
	public static Properties loadedConfig = getConfig();
	public int casesToTest = Integer.parseInt(getConfigForproperty("casesToTest"));
	public String hubURL = getConfigForproperty("hubURL");
	public List<String>           log          = new ArrayList<>();
	public static Properties loadedCreateConfig = getCreateApp();

	public CommonCode() {
	}

	public CommonCode(RemoteWebDriver driver) {
		super();
		CommonCode.driver = driver;
	}

	public void RefreshBrowser() {
		for (int i = 1; i <= 3; i++) {
			driver.navigate().refresh();
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static Properties getConfig() {
		InputStream input = null;
		input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		final Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String getConfigForproperty(String prop) {
		return loadedConfig.getProperty(prop);

	}

	private static Properties getCreateApp() {
		InputStream input = null;
		input = Thread.currentThread().getContextClassLoader().getResourceAsStream("CreateApplication.properties");
		final Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String getCreateproperty(String prop) {
		return loadedCreateConfig.getProperty(prop);

	}

	public void acceptAlter() throws NoAlertPresentException {
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();

	}

	public static List<WebElement> WaitForElements(List<WebElement> eles, WebDriver driver) {
		ArrayList<WebElement> element = new ArrayList<WebElement>();

		try {
			for (WebElement elements : eles) {
				element.add((new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(elements)));
			}
		} catch (Exception e) {

		}
		return element;
	}

	public static boolean isElementPresent(WebElement element) {
		int flag = 0;
		try {

			element.getTagName();

		} catch (final org.openqa.selenium.NoSuchElementException e) {
			flag = 1;
		}
		if (flag == 0)
			return true;
		else
			return false;
	}

	public static void Clickable(WebElement element) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		element.click();
	}

	public static void WaitForText(WebElement element, String expected) {
		System.out.println("Waiting for " + expected + " text to appear");
		try {
			final WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(element, expected));
		} catch (final org.openqa.selenium.TimeoutException e) {
			writeScreenshotToFile(driver);
			System.out.println("Expected String not present");
		}
	}

	public boolean verifyElementPresent(WebElement ele) {
		try {
			if (ele != null) {
				System.out.println("Element Found");
				return true;
			} else {
				System.out.println("Invalid Element");
				return false;
			}
		} catch (final Exception ex) {
			System.out.println("Element Not Present");
		}
		return false;

	}

	@Attachment
	public String Load_Time(double totaltime) {
		return "Load Time : " + totaltime + " secs";
	}

	@Attachment
	public String CaseLoadTime(double totaltime) {
		return "Time to Load displayed 10 cases : " + totaltime + " secs";
	}

	@Attachment()
	public String Log(List<String> list) {
		String str = "";

		for (final String s : list) {
			str += "" + s + "\n";
		}
		return str;
	}

	@Attachment(value = "Screen Capture", type = "image/png")
	public static byte[] writeScreenshotToFile(WebDriver driver) {
		final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			final FileOutputStream screenshotStream = new FileOutputStream(scrFile);
			final byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			screenshotStream.write(bytes);
			screenshotStream.close();
			return bytes;
		} catch (final IOException unableToWriteScreenshot) {
			System.err.println("Unable to write " + scrFile.getAbsolutePath());
			unableToWriteScreenshot.printStackTrace();
		}
		return null;
	}

	public static WebElement WaitForBy(By by, WebDriver driver) {

		try {
			return new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(by));
		}

		catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;
	}

	public static WebElement waitForElement(WebElement element, WebDriver driver) {
		try {

			return new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(element));
		}

		catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;
	}

	public static WebElement waitForElementTime(WebElement element, WebDriver driver) {
		try {

			return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		}

		catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;
	}

	public static WebElement WaitForElementToBeClickable(WebElement element, WebDriver driver) {
		try {

			return new WebDriverWait(driver, 80).until(ExpectedConditions.elementToBeClickable(element));
		}

		catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;
	}

	public static WebElement waitAjaxCall(WebElement element, WebDriver driver) {
		try {
			return new WebDriverWait(driver, 80).until(ExpectedConditions.elementToBeClickable(element));
		} catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;

	}

	public static WebElement waitForPageFactory(WebElement element, WebDriver driver) {
		try {
			element = new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(element));
			highLightElement(driver, element);
			element.getText();
			return element;
		} catch (final StaleElementReferenceException e) {
			handleStaleElement(element);
		} catch (final Exception e) {
			System.out.println("Element Not Present.");
		}
		return null;
	}

	public static void handleStaleElement(WebElement elementName) {
		int count = 0;
		// It will try 4 times to find same element using name.
		while (count < 4) {
			try {
				elementName.getText();
			} catch (final StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count + 1;
			}
			count = count + 4;
		}
	}

	public static void highLightElement(WebDriver driver, WebElement element) {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(250);
		} catch (final InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public static boolean verifyElementNotPresent(By locator, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(locator);
			return true;
		} catch (final NoSuchElementException e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public boolean verifyListElements(List<WebElement> elements) {

		for (final WebElement element : elements) {
			try {
				if (element != null) {
					System.out.println("Element Found");
				} else {
					System.out.println("Invalid Element");
					return false;
				}
			} catch (final Exception e) {
				System.out.println("Caught");
			}
		}
		return true;

	}

	public boolean verifyByElement(By element) {

		try {
			if (element.equals(null)) {
				System.out.println("Invalid Element");
				return false;
			} else {
				return true;
			}
		} catch (final Exception e) {
			System.out.println("Caught");
		}

		return false;

	}

	public boolean verifyElement(WebElement element) {

		try {
			if (element.equals(null)) {
				System.out.println("Invalid Element");
				return false;
			} else {
				return true;
			}
		} catch (final Exception e) {
			System.out.println("Caught");
		}

		return false;

	}

	public boolean verify(List<WebElement> elements) {

		for (WebElement element : elements) {
			try {
				if (element != null) {
					System.out.println("Element Found");
				} else {
					System.out.println("Invalid Element");
					return false;
				}
			} catch (Exception e) {
				System.out.println("Caught");
			}
		}
		return true;

	}

	public static List<WebElement> WaitForListBys(List<By> bys, WebDriver driver) {
		final ArrayList<WebElement> element = new ArrayList<>();

		try {
			for (final By by : bys) {
				element.add(new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(by)));
			}
		} catch (final Exception e) {
			System.out.println("Caught");

		}
		return element;
	}

	public int elementCount(By Element) {
		try {
			Thread.sleep(1200);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(Element).size();
	}

	public void waitingMethod(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
