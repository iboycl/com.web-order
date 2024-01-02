import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_001_LP_01 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter "Inar" as
	 * username and "Academy" password. 4-) Click on the "Login" button. 5-) Verify that
	 * the user is successfully logged in.
	 *
	 */
	@Test
	void verifyLoginFunctionality() throws InterruptedException {

		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderButton.click();

		// 3-) Enter "Inar" as username and "Academy" password.
		WebElement userIdInputField = driver.findElement(By.id("login-username-input"));
		userIdInputField.sendKeys("Inar");

		WebElement userPasswordInputField = driver.findElement(By.id("login-password-input"));
		userPasswordInputField.sendKeys("Academy");

		// 4-) Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 5-) Verify that the user is successfully logged in.
		WebElement welcomeHeading = driver.findElement(By.id("welcome-heading"));

		assertEquals("Welcome, Inar!", welcomeHeading.getText());
	}

}
