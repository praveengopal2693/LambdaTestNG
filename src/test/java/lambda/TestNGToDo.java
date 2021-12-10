package lambda;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Platform;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;
import java.net.URL;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGToDo {
		
	public String username = "vijipraveen18";
	  public String accesskey = "E6n7LpFEjCLpfwVJrUN9abeGU4dAY41nyzgrR8Ye22n3iR6NIk";
	  public RemoteWebDriver driver = null;
	  public String gridURL = "@hub.lambdatest.com/wd/hub";
	  boolean status = false;
	  @BeforeTest
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	      capabilities.setCapability("build", "LambdaTestSampleApp");
	      capabilities.setCapability("name", "LambdaTestJavaSample");
	     
	      try {
	          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	  }


	@Test
	public void lamassignment() throws InterruptedException, IOException, AWTException
	{
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-automation/");

		Homepage Home = new Homepage(driver);
	    Home.Homevalidations();
        driver.quit();
	   
	}

  }
