// Automation script using Selenium Webdriver + Junit 4 / Browser Stack + Single Run

package bs_single;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




public class Singlerun {
	private WebDriver driver;  

	@Before
	public void setup() throws InterruptedException, MalformedURLException {
		
		/*************** This is for Windows-7 and FF-23 ************* This is Single run*/ 
		
		DesiredCapabilities caps = new DesiredCapabilities();
		/*caps.setCapability("browser", "Firefox");
		caps.setCapability("browser_version", "23.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.debug", "true");*/
				
		/*************** This is for Windows-8 and Safari 5.1 ************* This is Single run*/ 
		
		caps.setCapability("browser", "Safari");
		caps.setCapability("browser_version", "5.1");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "8");
		caps.setCapability("resolution", "1024x768");
		
        driver = new RemoteWebDriver(new URL("http://BaluMahesh:xd1qOVAkdFNMvkMYSQi5@hub.browserstack.com/wd/hub"),caps); // This is to run the test through Browser Stack
	     		      
	}
			    
			
	@Test
	
	public void test1() throws InterruptedException {
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://www.jewelstreet.com/"); // Navigate to Jewelstreet.com
		Thread.sleep(4000);
		driver.findElement(By.id("loginLink")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("Tech_Geek@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("slogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("closeLink2")).click();
		System.out.print("\nSelenium webdriver +Junit through browser stack is executed successfully");
	
		
	}

	@After
	public void aftertest() {
		driver.quit();
	}

}