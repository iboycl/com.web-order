import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_004_CF_01 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "HomeDecor" from Product dropdown. 6-) Enter "5" as quantity number. 7-) Enter "15"
	 * as discount percentage. 8-) Click on the "Calculate" button. 9-) Verify that the
	 * total amount is successfully displayed.
	 */
	@Test
	void verifyCalculateFunctionalityInOrderPage() throws InterruptedException {
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

		// 5-) Select "HomeDecor" from Product dropdown.
		WebElement productSelector = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productSelector);
		productSelect.selectByValue("HomeDecor");

		// 6-) Enter "5" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("5");

		// 7-) Enter "15" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("15");

		// 8-) Click on the "Calculate" button.
		WebElement buttonCalculate = driver.findElement(By.xpath("//button[text()='Calculate']"));
		buttonCalculate.click();

		// 9-) Verify that the total amount is successfully displayed.
		WebElement totalTextField = driver.findElement(By.id("totalInput"));
		assertEquals("638", totalTextField.getAttribute("value"));
	}

}
