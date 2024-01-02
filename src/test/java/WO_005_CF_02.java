import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_005_CF_02 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "ScreenSaver" from Product dropdown. 6-) Leave blank the quantity box. 7-) Enter
	 * "20" as discount percentage. 8-) Click on the "Calculate" button. 9-) Verify the
	 * invalid Quantity error message is displayed.
	 *
	 */
	@Test
	void verifyCalculateFunctionalityInOrderPageInvalidInput() throws InterruptedException {
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

		// 5-) Select "ScreenSaver" from Product dropdown.
		WebElement productSelector = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productSelector);
		productSelect.selectByValue("ScreenSaver");

		// 6-) Leave blank the quantity box.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("");

		// 7-) Enter "20" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("20");

		// 8-) Click on the "Calculate" button.
		WebElement buttonCalculate = driver.findElement(By.xpath("//button[text()='Calculate']"));
		buttonCalculate.click();

		// 9-) Verify that the total amount is successfully displayed.
		WebElement quantityValidateErrorText = driver.findElement(By.id("quantityValidateError"));
		assertTrue(quantityValidateErrorText.isDisplayed());
	}

}
