package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC1_Login_SD {
	public static WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else {
			driver=new EdgeDriver();
		}
	}
	@Test(priority=1)
	@Parameters("url")
	public void launch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=2,dataProvider="SDdata")
	public void login(String username,String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		//assertion
		SoftAssert sa=new SoftAssert();
		
		sa.assertTrue(driver.findElement(By.xpath("//span[text()='Produc']")).isDisplayed());
		sa.assertAll();
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	@DataProvider(name="SDdata")
	public String[][] loginData(){
		String data[][]= {
				{"standard_user","secret_sauce"}
		};
		return data;
	}
}


