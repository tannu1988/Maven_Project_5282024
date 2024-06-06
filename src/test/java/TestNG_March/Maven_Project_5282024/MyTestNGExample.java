package TestNG_March.Maven_Project_5282024;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MyTestNGExample {
	@BeforeMethod
	public void openBrowser() {
		System.out.println("Opening browser");
	}
	@Test
	public void testFirstProgram() {
		System.out.println("Testing First Program");
	}
	@Test(enabled = false)
	public void testSecondProgram() {
		System.out.println("Testing Second Program");
	}
	@Ignore
	@Test(invocationCount = 2)
	public void testThirdProgram() {
		System.out.println("Testing Third Program");
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("closing browser");
	}

}
