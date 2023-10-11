package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import common.CommonActions;
import constants.KeyConfig;
import static constants.IBrowserConstant.*;

import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

import utils.ReadConfig;
import utils.ReadFile;

public class TestBase {
 static WebDriver driver;// 
	static ReadConfig config;//
	public static HomePage homePage;
	protected Select select;
	protected JavascriptExecutor jsExecutor;
	ReadFile readFile;

//Before Suite not needed as we didnot create extent report
	public static WebDriver getDriver() {
		return driver;
		}

	public static void beforeClassSetUp() {// have to make it static !! reason??
		config = new ReadConfig();// initializing 01

	}

	public void setUpDriver(String browserName) {

		driver = initiliazingBrowser(browserName);// initializing 02

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		int pageloadwait = Integer.parseInt(config.getValue(KeyConfig.pageloadwait));// conversion because it was in
																						// string @config.properties
		int implicitlywait = Integer.parseInt(config.getValue(KeyConfig.implicitlywait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadwait));// calling by the name use for int
																						// conversion!!
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlywait));
		driver.get(config.getValue(KeyConfig.url));
		initObjectClass();// to use the homePage we need to call the method created
	}

	public WebDriver initiliazingBrowser(String browserName) {// return type method
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();// version not defined so latest
			return new ChromeDriver();
		// break; as we are returning the value we don't have to use the break!!
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();// version not defined so latest
			return new FirefoxDriver();
		case EDGE:
			WebDriverManager.edgedriver().setup();// version not defined so latest
			return new EdgeDriver();
		case SAFARI:
			WebDriverManager.safaridriver().setup();// version not defined so latest
			return new SafariDriver();
		default:
			System.out.println("default");
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}

	}

	public void initObjectClass() {
		homePage = new HomePage(driver);
	}

	public void tearUp() {
		driver.quit();
	}

}
