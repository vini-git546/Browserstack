// Search functionality snippet

package yr_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

public class Search {

	  private WebDriver driver;

	    @Before
	    public void setUp() throws Exception {
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

	    @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

	    @Test
	    public void testSearchExportedFromIDE() throws Exception {
	    	driver.manage().window().maximize();
	        String baseUrl = "http://www.yr.no";
	        driver.get(baseUrl + "/");
	        Thread.sleep(1000);
	        //driver.findElement(By.cssSelector("span.yr-icon.yr-icon-flag-nor")).click();
	        //driver.findElement(By.linkText("English")).click();	
	        //Thread.sleep(2000);

	        WebElement searchField = driver.findElement(By.id("sted"));
	        searchField.clear();
	        searchField.sendKeys("Stockholm");
	        searchField.submit();
	        Thread.sleep(2000);

	        String topLinkXPathExpression = "//div[@id='directories']/table/tbody/tr/td[6]/a";
	        Thread.sleep(1000);
	        WebElement topSearchResult = driver.findElement(By.xpath(topLinkXPathExpression));
	        topSearchResult.click();
	        Thread.sleep(1000);

	        driver.findElement(By.cssSelector("li")).click();
	        String expected = "Stockholm";
	        WebElement actualHeadLine = driver.findElement(By.cssSelector("h1"));
	        String actual = actualHeadLine.getText();
	        assertTrue(actual.contains(expected));
	    }
	}

	

