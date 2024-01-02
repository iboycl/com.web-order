import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_009_OP_04 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "SportsEquipment" from Product dropdown. 6-) Enter "1" as quantity number. 7-)
	 * Enter "10" as discount percentage. 8-) Click on the "Calculate" button. 9-) Enter
	 * "Inar Academy" as Name. 10-) Enter "1100 Congress Ave" as Street. 11-) Enter
	 * "Austin" as City. 12-) Enter "TX" State. 13-) Enter "78701" as Zip Code(number).
	 * 14-) Enter "4938220192845" as Card Number. 15-) Enter "09/26" Expire Date(mm/yy
	 * format). 16-) Click "Process"" button. 17-) Verify the Card Type error message is
	 * displayed.
	 *
	 *
	 *
	 */
	@Test
	void verifyOrderPlacementwithoutCardType() throws InterruptedException {
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

		// 5-) Select "SportsEquipment" from Product dropdown.
		WebElement productSelector = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productSelector);
		productSelect.selectByValue("SportsEquipment");

		// 6-) Enter "1" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("1");

		// 7-) Enter "10" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("10");

		// 8-) Click on the "Calculate" button.
		WebElement buttonCalculate = driver.findElement(By.xpath("//button[text()='Calculate']"));
		buttonCalculate.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,750)");

		Thread.sleep(1000);

		// 9-) Enter "Inar Academy" as Name.
		WebElement nameInputField = driver.findElement(By.id("name"));
		nameInputField.sendKeys("Inar Academy");

		// 10-) Enter "1100 Congress Ave" as Street.
		WebElement streetInputField = driver.findElement(By.id("street"));
		streetInputField.sendKeys("1100 Congress Ave");

		// 11-) Enter "Austin" as City.
		WebElement cityInputField = driver.findElement(By.id("city"));
		cityInputField.sendKeys("Austin");

		// 12-) Enter "TX" State.
		WebElement stateInputField = driver.findElement(By.id("state"));
		stateInputField.sendKeys("TX");

		// 13-) Enter "92@#83" as Zip Code(number).
		WebElement zipInputField = driver.findElement(By.id("zip"));
		zipInputField.sendKeys("78701");

		// 14-) Enter "4938220192845" as Card Number.
		WebElement cardNumberInputField = driver.findElement(By.id("cardNumber"));
		cardNumberInputField.sendKeys("4938220192845");

		// 15-) Enter "09/26" Expire Date(mm/yy format).
		WebElement expiryDateInputField = driver.findElement(By.id("expiryDate"));
		expiryDateInputField.sendKeys("01/28");

		// 16-) Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();

		// 17-) Verify the Card Type error message is displayed
		WebElement invalidProductInformationAlert = driver
			.findElement(By.xpath("//em[text()='Card type cannot be empty']"));
		assertTrue(invalidProductInformationAlert.isDisplayed(), "Order is accepted without card type!");
	}

}
