package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends LoginPage{
	
	
	public LoginTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	void login() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LoginPage lp=new LoginPage(driver);
		lp.set_Username();
		lp.set_password();
		lp.click_login();
	}
}



