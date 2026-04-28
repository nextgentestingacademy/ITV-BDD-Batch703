package base;

import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class BaseClass {
	protected static WebDriver driver;

	@Before()
	public static void setup() {
		String browser = ConfigReader.get("browser");
//		String browser = System.getProperty("browser","chrome");

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = new InternetExplorerDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.get(ConfigReader.get("url"));
		LoggerUtils.info("Launched the application");
		int time = Integer.parseInt(ConfigReader.get("timeout"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	@After()
	public static void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ScreenshotUtils.capture(driver, scenario, scenario.getName());
		}
		driver.quit();
		LoggerUtils.info("Closed the browser");
	}

	public static void elementClick(WebElement elm) {
		if (elm.isDisplayed()) {
			if (elm.isEnabled()) {
				elm.click();
			} else {
				LoggerUtils.fail("Element is not enabled");
			}
		} else {
			LoggerUtils.fail("Element is not displayed");
		}
	}

	public static void enterText(WebElement elm, String text) {
		if (elm.isDisplayed()) {
			if (elm.isEnabled()) {
				elm.sendKeys(text);
			} else {
				LoggerUtils.fail("Element is not enabled");
			}
		} else {
			LoggerUtils.fail("Element is not displayed");
		}
	}
}