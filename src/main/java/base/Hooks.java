package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.IBrowserConstant;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.ReadConfig;

public class Hooks {
	
	static TestBase base;//can't import so declared  static  and initialized below
	@BeforeAll
	public static void beforeAll() {
		base=new TestBase();
		base.config = new ReadConfig();
	}
	@Before//import from io.cucumber and no Such thing called beforeMethod!!
	public static void preStep() {
			base.setUpDriver(IBrowserConstant.CHROME);
	}
@After
public void tearUp(Scenario scenario) {
	if(scenario.isFailed()) {
	final byte []  ss=((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
	scenario.attach(ss, "image/png", "error.png");
	}
	base.tearUp();//in base clase there is method for tearUp .. Called them.
}
}