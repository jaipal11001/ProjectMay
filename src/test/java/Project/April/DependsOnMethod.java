package Project.April;

import org.testng.Assert;
import org.testng.annotations.Test;



public class DependsOnMethod {
	@Test(priority=1,invocationCount=3)
	void launch() {
		//Using assertion to fail or pass the methods
		Assert.assertTrue(false);
	}
	@Test(priority=2,dependsOnMethods= {"launch"})
	void login() {
		Assert.assertTrue(true);
	}
	@Test(priority=3,dependsOnMethods= {"login"})
	void logout() {
		Assert.assertTrue(true);
	}
}


