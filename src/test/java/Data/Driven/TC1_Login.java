package Data.Driven;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TC1_Login {
	
	public static WebDriver driver;
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test
	void Login() throws IOException {
		//location of file
		String file=System.getProperty("user.dir")+"/TestData/LoginData.xlsx";
		//get num of rows
		int rows=Utils.getRowCount(file, "Sheet1");
		for(int r=0;r<=rows;r++) {
			//read
			String username=Utils.getCellData(file, "Sheet1", r, 0);
			String password=Utils.getCellData(file, "Sheet1", r, 1);
			
			//pass to website
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			//validation
			String exp="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			
			String act=driver.getCurrentUrl();
			if(act.equals(exp)) {
				System.out.println("Test is passed");
				Utils.setCellData(file, "Sheet1", r, 2, "Pass");
				Utils.fillGreenColour(file, "Sheet1", r, 2);
				//logout
				driver.findElement(By.className("oxd-userdropdown-name")).click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
			}else {
				System.out.println("Test is failed");
				Utils.setCellData(file, "Sheet1", r, 2, "Fail");
				Utils.fillRedColour(file, "Sheet1", r, 2);
			}
		}
	}
	@AfterClass
	void close() {
		driver.quit();
	}
}
