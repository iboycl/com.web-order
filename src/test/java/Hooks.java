import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

	protected static WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeAll
	static void setUpBeforeTest() throws InterruptedException {
		String browser = System.getProperty("browser", "chrome");

		switch (browser.toLowerCase()) {
			case "firefox" -> {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--width=1920");
				firefoxOptions.addArguments("--height=1080");
				driver = new FirefoxDriver(firefoxOptions);
			}
			case "edge" -> {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--start-maximized");
				edgeOptions.addArguments("--ignore-certificate-errors");
				driver = new EdgeDriver(edgeOptions);
			}
			default -> {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(chromeOptions);
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

		if (browser.equalsIgnoreCase("firefox")) {
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	}

	@AfterAll
	static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
