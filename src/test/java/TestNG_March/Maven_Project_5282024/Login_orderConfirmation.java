package TestNG_March.Maven_Project_5282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_orderConfirmation {

	WebDriver driver;
	Actions action;

	@BeforeMethod
	public void setUpBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		action = new Actions(driver);
	}

	@Test
	public void validateLoginFunctionality() throws InterruptedException {
		// email-address
		driver.findElement(By.id("input-email")).sendKeys("taranpreetkaur795@gmail.com");
		// password
		driver.findElement(By.id("input-password")).sendKeys("Tannu@1234");
		// login-button
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		//Assertion for successfully login
		String confirmationText = driver.findElement(By.cssSelector("#content h2:nth-of-type(1)")).getText();
		Assert.assertEquals(confirmationText, "My Account", "Email Login Successfully");
		//mouse hover on Laptops and Notebooks
		WebElement mouseHover = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		action.moveToElement(mouseHover).perform();
		//select "Show All Laptops & Notebooks" from "Laptops & Notebooks"
		driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")).click();
		//double click on product image
    	WebElement doubleClick = driver.findElement(By.cssSelector("#content > div:nth-child(7) > div:nth-child(1) > div > div.image > a > img"));
    	action.doubleClick(doubleClick).perform();
    	//after select the product click on add to cart button
    	driver.findElement(By.cssSelector("#button-cart")).click();
    	//Assertion for successfully added product to cart 
    	//Thread.sleep(1000);
    	//String addToCartConfirmation=driver.findElement(By.cssSelector("#product-product>div:nth-of-type(1)")).getText();
    	//Assert.assertEquals(addToCartConfirmation, "Success: You have added ");
    	Thread.sleep(1000);
    	//click on cart button
    	driver.findElement(By.cssSelector("#cart > button")).click();
    	//click on view cart
    	Thread.sleep(1000);
		driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1)>strong")).click();
		//double click on checkout button
		WebElement doubleClickOnCheckout = driver.findElement(By.xpath("//a[text()='Checkout']"));
		action.doubleClick(doubleClickOnCheckout).perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-payment-address")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-shipping-address")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-shipping-method")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#collapse-payment-method>div>div.buttons>div>input[type=checkbox]:nth-child(2)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-payment-method")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-confirm")).click();
//		Thread.sleep(1000);
//		String orderConfirm = driver.findElement(By.cssSelector("#content>p")).getText();
//		Assert.assertEquals(orderConfirm, "Your order has been successfully processed!");
	}

		@AfterMethod
		public void closingBrowser() {
			driver.quit();
		}

}
