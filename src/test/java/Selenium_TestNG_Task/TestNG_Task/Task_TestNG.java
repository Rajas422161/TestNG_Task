package Selenium_TestNG_Task.TestNG_Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_TestNG {

	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
	}

	@Test
	public void testEmptyStringReturnsZero() {
		WebElement inputField = driver.findElement(By.id("numbers"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
		WebElement result = driver.findElement(By.id("result"));

		inputField.clear();
		inputField.sendKeys("");
		submitButton.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(result.getText(), "Sum: 0");
	}

	@Test
	public void testSingleNumber() {
		WebElement inputField = driver.findElement(By.id("numbers"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
		WebElement result = driver.findElement(By.id("result"));

		inputField.clear();
		inputField.sendKeys("1");
		submitButton.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(result.getText(), "Sum: 1");
	}

	@Test
	public void testTwoNumbers() {
		WebElement inputField = driver.findElement(By.id("numbers"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
		WebElement result = driver.findElement(By.id("result"));

		inputField.clear();
		inputField.sendKeys("1,2");
		submitButton.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(result.getText(), "Sum: 3");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
