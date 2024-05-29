package Project.April;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Grouping {
public static WebDriver driver;
@Test(groups="Entertainment")
void youtube() {
	driver=new ChromeDriver();
	driver.get("https://www.youtube.com/results?search_query=v6+news+live");	
}
@Test(groups="Entertainment")
void jiocinema() {
	driver=new ChromeDriver();
	driver.get("https://www.jiocinema.com/");
	
}
@Test(groups="Education")
void ssc() {
	driver=new ChromeDriver();
	driver.get("https://sscsr.gov.in/");
	
}
@Test(groups="Electrical")

void SPDL() {
	driver=new ChromeDriver();
	driver.get("https://www.tssouthernpower.com/");
	
}
}
