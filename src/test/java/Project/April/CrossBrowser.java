package Project.April;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	public static WebDriver driver;
	@BeforeMethod
	@Parameters({"browser","url"})
	void launch(String browser,String url) {
		if(browser.equals("chrome")) {
		driver=new ChromeDriver();
		driver.get(url);
		}else {
			driver=new EdgeDriver();
			driver.get(url);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	@Parameters({"username","pwd"})
	void login(String username,String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
		
		System.out.println("Test is failed");
	}
	@AfterMethod
	void close() {
		driver.close();
	}
}

	
	
	
	

