package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {
	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://classic.freecrm.com/register/");

	}

	@Test
	public void validateLogin() {

		WebElement editionInput = driver.findElement(By
				.cssSelector("div.form-group.has-feedback:first-of-type select#payment_plan_id option:nth-of-type(2)"));
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='first_name']"));
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='surname']"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement confirmEmailInput = driver
				.findElement(By.xpath("//input[@class='form-control input-text' and @name='email_confirm']"));
		WebElement usernameInput = driver.findElement(By.cssSelector("div#username input"));
		WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement confirmPasswordInput = driver.findElement(By.cssSelector("div:nth-of-type(9) input"));
		WebElement checkBoxInput = driver.findElement(By.cssSelector("div.checkbox label input"));
		WebElement submitButton = driver.findElement(By.id("submitButton"));

		editionInput.click();
		firstNameInput.sendKeys("Taranpreet");
		lastNameInput.sendKeys("kaur");
		emailInput.sendKeys("taranpreetkaur795@gmail.com");
		confirmEmailInput.sendKeys("taranpreetkaur795@gmail.com");
		usernameInput.sendKeys("Tannu123");
		passwordInput.sendKeys("Tannu@123");
		confirmPasswordInput.sendKeys("Tannu@123");
		checkBoxInput.click();
		submitButton.click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
