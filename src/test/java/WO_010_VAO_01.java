import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_010_VAO_01 extends Hooks {

	/*
	 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click
	 * "Add More Data" "4" times. 6-) Click "Check All" button. 7-) Verify all orders
	 * selected.
	 *
	 */
	@Test
	void verifyCheckAllFunctionalityInViewAllOrderPage() throws InterruptedException {
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

		// 5-) Click "Add More Data" "4" times.
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text()='Add More Data']"));
		for (int i = 0; i < 4; i++) {
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

	}

}
