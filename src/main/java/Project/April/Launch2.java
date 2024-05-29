package Project.April;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Launch2 {
public static WebDriver driver;

@BeforeMethod
void Login() {
	System.out.println("Login");
}
@Test(priority=1)
void search() {
	System.out.println("search");
}
@Test(priority=2)
void addproduct() {
	System.out.println("addproduct");
}
@AfterMethod
void Logout() {
	System.out.println("Logout");
}


}
