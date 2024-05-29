package Project.April;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Launch {
public static WebDriver driver;

		
		@Test
		void launch()  {
			driver=new ChromeDriver();
driver.get("https://www.youtube.com/results?search_query=v6+news+live");
driver.manage().window().maximize();

	}

}
