package org.ual.hmis.equipo16;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListadoCorrectoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
    public void setUp() {

        // Browser selector

        int browser = -1; // 0: firefox, 1: chrome,...

        if (System.getProperty("webdriver.gecko.driver") != null) {
            browser = 0;
        }else if (System.getProperty("webdriver.chrome.driver") != null) {
            browser = 1;
        }

        Boolean headless = false;

        switch (browser) {
        case 0:  // firefox
            // Firefox
            // Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
            // Descomprimir el archivo geckodriver.exe en la carpeta drivers

            //System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headless) firefoxOptions.setHeadless(headless);
            driver = new FirefoxDriver(firefoxOptions);

            break;
        case 1: // chrome
            // Chrome
            // Descargar Chromedriver de https://chromedriver.chromium.org/downloads
            // Descomprimir el archivo chromedriver.exe en la carpeta drivers

            //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            if (headless) chromeOptions.setHeadless(headless);
            chromeOptions.addArguments("window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);

            break;

        default:
            fail("Seleccione un navegador");
            break;
        }
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void listadoCorrecto() {
		// Test name: listadoCorrecto
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://ecovivarenas.es/");
		// 2 | setWindowSize | 1552x840 |
		driver.manage().window().setSize(new Dimension(1552, 1500));
		if (!driver.findElements(By.id("btn-aceptar-cookies")).isEmpty()) {
			driver.findElement(By.id("btn-aceptar-cookies")).click();
		}
		// 3 | click | linkText=Verduras |
		driver.findElement(By.linkText("Verduras")).click();

		WebDriverWait wait1 = new WebDriverWait(driver,30);
        WebElement selectMensaje1 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(1)")));
		// 7 | click | css=.producto:nth-child(1) > .datosProducto |
		driver.findElement(By.cssSelector(".producto:nth-child(1) > .datosProducto")).click();
		// 8 | assertElementPresent | css=.producto:nth-child(1) > .datosProducto
		// input:nth-child(1) |
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector(".producto:nth-child(1) > .datosProducto input:nth-child(1)"));
			assert (elements.size() > 0);
		}
		// 9 | assertElementPresent | css=.producto:nth-child(2) > .datosProducto
		// input:nth-child(1) |
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector(".producto:nth-child(2) > .datosProducto input:nth-child(1)"));
			assert (elements.size() > 0);
		}
	}
}
