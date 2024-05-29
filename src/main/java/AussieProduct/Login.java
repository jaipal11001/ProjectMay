package AussieProduct;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver driver;
	@Test(dataProvider="loginData")
	void login(String userName, String password) throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.get("https://www.aussiehealthproducts.com.au/sign-in.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='userpassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(5000);
		String exp="https://www.aussiehealthproducts.com.au/snacks-biscuits.php";
		String act=driver.getCurrentUrl();
		if(act.equals(exp)) {
			System.out.println("Test is passed");
}else {
			System.out.println("Test is failed");
		driver.close();
}
	}		
	
@DataProvider(name="loginData")
public Object[][] login() {
	Object[][] data=new Object[2][2];
	data[0][0]="jatothjaipal114@gmail.com";
	data[0][1]="Jai@1001";
	
	data[1][0]="jaipaljatoth114@gmail.com";
	data[1][1]="jai@1001";
	
	return data;
}
}
