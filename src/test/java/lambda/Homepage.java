package lambda;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.AWTException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {
	
	public static WebDriver driver;
	
	public void Homevalidations() throws InterruptedException, IOException, AWTException
	   {
		   this.automation();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	   
	 }

	
    public Homepage(WebDriver driver )
    {
       Homepage.driver= driver;  	
    }

	public void automation() throws InterruptedException
	{
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Try LambdaTest Now !!']")));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[normalize-space()='Try LambdaTest Now !!']")));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	    actions.perform();
	    Thread.sleep(2000);

		driver.findElement(By.xpath("//div[4]/div/div[normalize-space(.)='CI/CD Tools' and contains(@class,'thumb-titel')]")).click();
		Actions a = new Actions(driver);
		WebElement link =driver.findElement(By.xpath("//div[4]//a[normalize-space(.)='Learn more']"));

		Thread.sleep(2000);
	    ((JavascriptExecutor) driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get("https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/");
	    
	    Thread.sleep(2000);
		String expected_url = "https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/";
        String current_url = driver.getCurrentUrl();
 
        Assert.assertTrue(expected_url.equals(current_url), "URL does not match\n");
        Thread.sleep(2000);
        System.out.println("AssertTrue Test Passed\n");
	
        Thread.sleep(2000);
	   WebElement elements = driver.findElement(By.xpath("//span[normalize-space()='Test on Browser Emulator']"));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	   Thread.sleep(500); 

	   Thread.sleep(2000);
	   WebElement element1 = driver.findElement(By.xpath("//h1[normalize-space()='Integrations With CI/CD Tools']"));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
	   
	 
	   driver.close();

	   driver.switchTo().window(winHandleBefore);

	   System.out.println("Parent window becomes Active");
	   driver.findElement(By.xpath("//button[normalize-space()='Resources']")).click();
	   driver.findElement(By.xpath("//header[@id='header']//a[normalize-space()='Newsletter']")).click();
	   driver.findElement(By.cssSelector("a[href='https://www.lambdatest.com/newsletter/editions/']")).click();
	 
	   
	   String heading = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[1]/div/div/div/h1")).getText();
	   String expected_title = "ALL EDITIONS";

       Assert.assertTrue(expected_title.equals(heading), "Title does not match\n");
       Thread.sleep(2000);
       System.out.println("AssertTrue Test Passed - Title is matched as expected\n");
	   
   }
   
}
