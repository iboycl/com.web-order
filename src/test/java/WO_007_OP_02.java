import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_007_OP_02 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "FamilyAlbum" from Product dropdown. 6-) Enter "3" as quantity number. 7-) Enter
	 * "17" as discount percentage. 8-) Enter "Inar Academy" as Name. 9-) Enter
	 * "1100 Congress Ave" as Street. 10-) Enter "Austin" as City. 11-) Enter "TX" State.
	 * 12-) Enter "78701" as Zip Code(number). 13-) Select "Mastercard" as Card Type. 14-)
	 * Enter "5162738261027163" as Card Number. 15-) Enter "11/28" Expire Date(mm/yy
	 * format). 16-) Click "Process"" button. 17-) Verify the invalid Product Information
	 * error message is displayed
	 *
	 *
	 */
	@Test
	void verifyOrderPlacementWithoutCalculation() throws InterruptedException {
		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderButton.click();

		// 3-) Enter valid username "Inar" and password "Academy".
		WebElement userIdInputField = driver.findElement(By.id("login-username-input"));
		userIdInputField.sendKeys("Inar");

		WebElement userPasswordInputField = driver.findElement(By.id("login-password-input"));
		userPasswordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 4-) Navigate to the order page.
		WebElement orderLink = driver.findElement(By.id("order-tab"));
		orderLink.click();

		// 5-) Select "FamilyAlbum" from Product dropdown.
		WebElement productSelector = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productSelector);
		productSelect.selectByValue("FamilyAlbum");

		// 6-) Enter "3" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("3");

		// 7-) Enter "17" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("17");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,750)");

		Thread.sleep(1000);

		// 8-) Enter "Inar Academy" as Name.
		WebElement nameInputField = driver.findElement(By.id("name"));
		nameInputField.sendKeys("Inar Academy");

		// 9-) Enter "1100 Congress Ave" as Street.
		WebElement streetInputField = driver.findElement(By.id("street"));
		streetInputField.sendKeys("1100 Congress Ave");

		// 10-) Enter "Austin" as City.
		WebElement cityInputField = driver.findElement(By.id("city"));
		cityInputField.sendKeys("Austin");

		// 11-) Enter "TX" State.
		WebElement stateInputField = driver.findElement(By.id("state"));
		stateInputField.sendKeys("TX");

		// 12-) Enter "78701" as Zip Code(number).
		WebElement zipInputField = driver.findElement(By.id("zip"));
		zipInputField.sendKeys("78701");

		// 13-) Select "Mastercard" as Card Type.
		WebElement visaRadioButton = driver.findElement(By.id("mastercard"));
		visaRadioButton.click();

		// 14-) Enter "5162738261027163" as Card Number.
		WebElement cardNumberInputField = driver.findElement(By.id("cardNumber"));
		cardNumberInputField.sendKeys("5162738261027163");

		// 15-) Enter "11/28" Expire Date(mm/yy format).
		WebElement expiryDateInputField = driver.findElement(By.id("expiryDate"));
		expiryDateInputField.sendKeys("11/28");

		// 16-) Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();

		js.executeScript("window.scroll(0,0)");
		Thread.sleep(1000);

		// 17-) Verify the invalid Product Information error message is displayed
		WebElement invalidProductInformationAlert = driver
			.findElement(By.xpath("//em[text()='Fix errors in Product Information ']"));
		assertTrue(invalidProductInformationAlert.isDisplayed());

		// error text-danger

	}

}
