package DataDrivenTestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class TC2_Login {
public static WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
	}
	@Test(dataProvider="data")
	void Login(String[] tdata) throws IOException {
		String username=tdata[0];
		String password=tdata[1];
			//pass to website
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
				
			driver.findElement(By.className("oxd-userdropdown-name")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	@AfterClass
	void close() {
		driver.quit();
	}
	@DataProvider(name="data")
	public Object[][] testData() throws IOException {
		String file=System.getProperty("user.dir")+"/Data/LoginData.xlsx";
		int rows=Utiles.getRowCount(file, "Sheet1");
		int cel=Utiles.getCellCount(file, "Sheet1", 0);
		
		Object [][] tdata=new Object[rows][cel];
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cel;j++) {
				tdata[i-1][j]=Utiles.getCellData(file, "Sheet1", i, j);//(0,0)(1,0)
			}
		}
		return tdata;
	}

}
