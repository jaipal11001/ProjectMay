package Project.April;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Launch4 {
	public static WebDriver driver;
	@Test
	void addproduct() {
		System.out.println("addproduct");
	}
	@AfterTest
	void logout() {
		System.out.println("logout");
	}

}
