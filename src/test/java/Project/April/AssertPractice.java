package Project.April;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class AssertPractice {

	public static WebDriver driver;
	@BeforeMethod
	void launch() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test 
	void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Jaipal");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		
		String exp="Dashboard";
		String act=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		//Hard Assert
		//Assert.assertEquals(act, exp, "Test passed");
		//soft assert
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(act, exp);
		sa.assertAll();
		
		System.out.println("Test is failed");
	}
	@AfterMethod
	void close() {
		driver.close();
	}
}


