package browserstack;

//import static org.junit.Assert.*;

//import java.io.File;
//import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

//import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parallelized.class)
public class JUnitParallelSample {
  private String platform;
  private String browserName;
  private String browserVersion;
  

  @Parameterized.Parameters
  public static LinkedList getEnvironments() throws Exception {
    LinkedList<String[]> env = new LinkedList();
    
/* These are the parameters for multiple browsers / OS required for parallel run */
    
    env.add(new String[]{Platform.XP.toString(), "chrome", "27"});
    env.add(new String[]{Platform.WINDOWS.toString(),"firefox","20"});
    //env.add(new String[]{Platform.WINDOWS.toString(),"ie","7"});
    //env.add(new String[]{Platform.WINDOWS.toString(),"opera","12.14"});
    //env.add(new String[]{Platform.MAC.toString(),"iPhone","iPhone 5"});
         
//add more browsers here

    return env;
  }

  public JUnitParallelSample(String platform,String browserName, String browserVersion) {
 /* Fetching and storing of Platform / browserName / browserVersion */
	  
    this.platform = platform;
    this.browserName = browserName;
    this.browserVersion = browserVersion;
  }

  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platform", platform);
    caps.setCapability("browser", browserName);
    caps.setCapability("browserVersion", browserVersion);
    caps.setCapability("build", "VIN - Scenario 1");
    caps.setCapability("browserstack.debug", "true");
    driver = new RemoteWebDriver(new URL("http://BaluMahesh:xd1qOVAkdFNMvkMYSQi5@hub.browserstack.com/wd/hub"), caps);  
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
	Thread.sleep(1000);
	System.out.print("\nExecuted successfully");

	}

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
