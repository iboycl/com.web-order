import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_011_VAO_02 extends Hooks {

	/*
	 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click
	 * "Add More Data" "6" times. 6-) Click "Check All" button. 7-) Verify all orders
	 * selected. 8-) Click "Uncheck All" button. 9-) Verify all orders are unselected.
	 *
	 */
	@Test
	void verifyUncheckAllFunctionalityInViewAllOrderPage() throws InterruptedException {
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

		// 4-) Navigate to the view all order page.
		WebElement viewAllOrdersTabLink = driver.findElement(By.id("view-orders-tab"));
		viewAllOrdersTabLink.click();

		// 5-) Click "Add More Data" "6" times.
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text()='Add More Data']"));
		for (int i = 0; i < 6; i++) {
			addMoreDataButton.click();
		}

		// 6-) Click "Check All" button.
		WebElement checkAllButton = driver.findElement(By.xpath("//button[text()='Check All']"));
		checkAllButton.click();

		// 7-) Verify all orders selected.
		List<WebElement> orderCheckBoxes = driver.findElements(By.className("form-check-input"));

		for (WebElement element : orderCheckBoxes) {
			assertTrue(element.isSelected());
		}

		// 8-) Click "Uncheck All" button.
		WebElement uncheckAllButton = driver.findElement(By.xpath("//button[text()='Uncheck All']"));
		uncheckAllButton.click();

		// 9-) Verify all orders are unselected.
		for (WebElement element : orderCheckBoxes) {
			assertFalse(element.isSelected());
		}
	}

}
