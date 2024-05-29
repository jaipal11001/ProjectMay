package Project.April;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Launch3 {
	public static WebDriver driver;
	@BeforeTest
	void Login() {
		System.out.println("Login");
	}
	@Test
	void search() {
		System.out.println("search");
	}

}
