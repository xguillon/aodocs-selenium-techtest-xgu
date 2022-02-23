package selenium.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aodocs.test.core.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	public static WebDriver getWebDriver(Browser browser) {
		WebDriver webDriver;
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver(getFireFoxOptions());
			break;
		case CHROME:
		default:
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver(getChromeOptions());
		}
		webDriver.manage().window().maximize();

		return webDriver;
	}

	public static WebDriver getGridWebDriver(Browser browser) throws MalformedURLException {

		WebDriver webdriver;
		switch (Environment.getConfig().getBrowserEnum()) {
		case FIREFOX:
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("marionette", true);
			caps.setBrowserName("firefox");
			webdriver = new RemoteWebDriver(new URL(Environment.getConfig().getGridServer()), caps);
			break;
		case CHROME:
		default:
			webdriver = new RemoteWebDriver(new URL(Environment.getConfig().getGridServer()), getChromeOptions());
			break;
		}

		webdriver.manage().window().maximize();

		return webdriver;

	}

	public static void closeWebDriver(WebDriver webDriver) {
		if (webDriver != null)
			webDriver.quit();
	}

	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		// To start chrome in english
		options.addArguments("lang=en-GB");
		// To start chrome without security warning
		options.addArguments("disable-infobars");
		return options;
	}

	private static FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en-GB");
		options.setProfile(profile);
		return options;
	}

}
