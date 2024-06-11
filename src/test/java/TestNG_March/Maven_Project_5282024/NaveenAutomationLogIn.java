package TestNG_March.Maven_Project_5282024;

import java.io.IOException;
import java.net.ServerSocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAutomationLogIn {

	WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test(priority = 1)
	public void validateLoginFunctionality() {
		// email-address
		driver.findElement(By.id("input-email")).sendKeys("taranpreetkaur795@gmail.com");
		// password
		driver.findElement(By.id("input-password")).sendKeys("Tannu@1234");
		// login-button
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void validateForgottenPassword() {
		// email-address
		driver.findElement(By.id("input-email")).sendKeys("taranpreetkaur795@gmail.com");
		// forgotten-password
		driver.findElement(By.cssSelector("div.form-group:nth-of-type(2) a")).click();

		driver.findElement(By.id("input-email")).sendKeys("taranpreetkaur795@gmail.com");
		// continue
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		String confirmationLinkText = driver.findElement(By.cssSelector("#account-login div ")).getText();
		Assert.assertEquals(confirmationLinkText,
				"An email with a confirmation link has been sent your email address.");

	}

	@AfterMethod
	public void closingBrowser() {
		driver.quit();
	}

}
