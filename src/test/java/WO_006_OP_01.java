import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_006_OP_01 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select "MyMoney"
	 * from Product dropdown. 6-) Enter "8" as quantity number. 7-) Enter "20" as discount
	 * percentage. 8-) Click on the "Calculate" button. 9-) Enter "Inar Academy" as Name.
	 * 10-) Enter "1100 Congress Ave" as Street. 11-) Enter "Austin" as City. 12-) Enter
	 * "TX" State. 13-) Enter "78701" as Zip Code(number). 14-) Select "Visa" as Card
	 * Type. 15-) Enter "4938281746192845" as Card Number. 16-) Enter "11/28" Expire
	 * Date(mm/yy format). 17-) Click "Process"" button. 18-) Verify the confirmation
	 * message is displayed. 19-) Navigate to view all orders page. 20-) Verify the order
	 * is successfully placed.
	 *
	 *
	 */
	@Test
	void verifyOrderPlacement() throws InterruptedException {
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

		// 5-) Select "MyMoney" from Product dropdown.
		WebElement productSelector = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productSelector);
		productSelect.selectByValue("MyMoney");

		// 6-) Enter "8" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("8");

		// 7-) Enter "20" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("20");

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

		// 13-) Enter "78701" as Zip Code(number).
		WebElement zipInputField = driver.findElement(By.id("zip"));
		zipInputField.sendKeys("78701");

		// 14-) Select "Visa" as Card Type.
		WebElement visaRadioButton = driver.findElement(By.id("visa"));
		visaRadioButton.click();

		// 15-) Enter "4938281746192845" as Card Number.
		WebElement cardNumberInputField = driver.findElement(By.id("cardNumber"));
		cardNumberInputField.sendKeys("4938281746192845");

		// 16-) Enter "11/28" Expire Date(mm/yy format).
		WebElement expiryDateInputField = driver.findElement(By.id("expiryDate"));
		expiryDateInputField.sendKeys("11/28");

		// 17-) Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();

		// 18-) Verify the confirmation message is displayed.
		WebElement processConfirmationAlert = driver.findElement(By.xpath("//div[@role='alert']"));
		assertEquals("New order has been successfully added.", processConfirmationAlert.getText());

		// 19-) Navigate to view all orders page.
		WebElement viewOrdersLink = driver.findElement(By.id("view-orders-tab"));
		viewOrdersLink.click();

		// 20-) Verify the order is successfully placed.
		List<WebElement> rowsOfOrderTable = driver.findElements(By.cssSelector("tbody > tr"));
		List<WebElement> lastRowCells = rowsOfOrderTable.get(rowsOfOrderTable.size() - 1)
			.findElements(By.cssSelector("td"));

		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String lastRowCellContent = "";
		String expectedRowContent = "Inar AcademyMyMoney8" + currentDate
				+ "1100 Congress AveAustinTX78701Visa493828174619284511/28";
		for (int i = 1; i < lastRowCells.size(); i++) {
			lastRowCellContent = lastRowCellContent.concat(lastRowCells.get(i).getText());
		}

		assertEquals(expectedRowContent, lastRowCellContent);

	}

}
