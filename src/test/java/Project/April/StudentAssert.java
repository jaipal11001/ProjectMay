package Project.April;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentAssert {
	public static WebDriver student;
	@BeforeMethod
	void practice() {
		student=new ChromeDriver();
		student.get("https://practicetestautomation.com/practice-test-login/");
		student.manage().window().maximize();
		student.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}
	@Test
	void login()  {
		student.findElement(By.xpath("//input[@name='username']")).sendKeys("student");
		student.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		student.findElement(By.xpath("//button[@id='submit']")).click();		
		
	}
				
	}

