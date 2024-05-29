package Project.April;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterDataProvider {

	public static WebDriver driver;
	@Test(dataProvider="loginTestData")
	void login(String userName, String password) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());
		
		driver.close();
	}

	/*@DataProvider(name="loginTestData")
	public Object[][] loginData() {
		Object[][] data=new Object[2][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		
		data[1][0]="jaipal";
		data[1][1]="jaipal@1001";
		
		return data;
	
	}*/
	@DataProvider(name="loginTestData")
	public String[][] loginData(){
		String data[][]= {
				{"admin","admin123"},
				{"vamshi","vam@123"}
				
		};
		return data;
	}	
}
