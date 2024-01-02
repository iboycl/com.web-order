import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WO_012_VAO_03 extends Hooks {

	/*
	 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click
	 * "Add More Data" "8" times. 6-) Click 1st, 3rd and 5th orders' checkboxes. 7-) Click
	 * "Delete" button. 8-) Verify the orders are deleted.
	 */
	@Test
	void verifyDeleteFunctionalityInViewAllOrderPage() throws InterruptedException {
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

		// 5-) Click "Add More Data" "8" times.
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text()='Add More Data']"));
		for (int i = 0; i < 8; i++) {
			addMoreDataButton.click();
		}

		// 6-) Click 1st, 3rd and 5th orders' checkboxes.
		int[] indexes = { 1, 3, 5 };

		// Created a string list to store selected rows' data before deleting them.
		ArrayList<String> selectedRowsData = new ArrayList<>();
		for (int i = 0; i < indexes.length; i++) {
			String path = "//*/table/tbody/tr[" + indexes[i] + "]/td[1]/div/input";
			WebElement checkBox = driver.findElement(By.xpath(path));
			checkBox.click();
			List<WebElement> selectedRow = driver.findElements(By.xpath("//*/table/tbody/tr[" + indexes[i] + "]/td"));
			String rowContent = "";
			for (int j = 1; j < selectedRow.size(); j++) {
				rowContent = rowContent.concat(selectedRow.get(j).getText());
			}
			selectedRowsData.add(rowContent);
		}

		// 7-) Click "Delete" button.
		WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteButton.click();

		Thread.sleep(5000);

		// 8-) Verify the orders are deleted.
		List<WebElement> rowsOfOrderTable = driver.findElements(By.cssSelector("tbody > tr"));

		for (int i = 0; i < rowsOfOrderTable.size(); i++) {
			String currentRowContent = "";
			List<WebElement> currentRowCells = rowsOfOrderTable.get(i).findElements(By.cssSelector("td"));

			for (int j = 1; j < currentRowCells.size(); j++) {
				currentRowContent = currentRowContent.concat(currentRowCells.get(j).getText());
			}

			for (int j = 0; j < selectedRowsData.size(); j++) {
				assertNotEquals(selectedRowsData.get(j), currentRowContent);
			}

		}
	}

}
