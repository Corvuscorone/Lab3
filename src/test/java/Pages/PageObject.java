package Pages;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObject{
	
	protected static WebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		capability.setBrowserName("firefox");
//		driver = new RemoteWebDriver(new URL("http://192.168.1.71:5566/wd/hub"),capability);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
	}
	
	@After
	public void after(){
		driver.quit();
	}
}