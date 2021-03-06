package org.ual.hmis.equipo16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ModificacionIncorrectoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {

        // Browser selector
        //System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        int browser = -1; // 0: firefox, 1: chrome,...

        if (System.getProperty("webdriver.gecko.driver") != null) {
            browser = 0;
        }else if (System.getProperty("webdriver.chrome.driver") != null) {
            browser = 1;
        }

        Boolean headless = true;

        switch (browser) {
        case 0:  // firefox

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headless) firefoxOptions.setHeadless(headless);
            driver = new FirefoxDriver(firefoxOptions);

            break;
        case 1: // chrome

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
	public void modificacionIncorrecto() {
		// Test name: modificacionIncorrecto
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://ecovivarenas.es/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		if (!driver.findElements(By.id("btn-aceptar-cookies")).isEmpty()) {
			driver.findElement(By.id("btn-aceptar-cookies")).click();
		}
		// 3 | click | id=carrito |
		driver.findElement(By.id("carrito")).click();
		// 4 | click | id=inicio-correo |
		driver.findElement(By.id("inicio-correo")).click();
		// 5 | type | id=inicio-correo | hmis@ual.es
		driver.findElement(By.id("inicio-correo")).sendKeys("hmis@ual.es");
		// 6 | type | id=inicio-contrasena | HmisHmis2022
		driver.findElement(By.id("inicio-contrasena")).sendKeys("HmisHmis2022");
		// 7 | click | id=iniciar |
		driver.findElement(By.id("iniciar")).click();
		// 8 | click | linkText=VER CUENTA |
		driver.findElement(By.linkText("VER CUENTA")).click();
		// 9 | click | id=misdatos |
		driver.findElement(By.id("misdatos")).click();
		// 10 | click | id=botonContrasena |
		driver.findElement(By.id("botonContrasena")).click();
		// 12 | click | id=contrasena |
		driver.findElement(By.id("contrasena")).click();
		// 13 | executeScript | return "HmisHmis" + Math.floor(Math.random()*1500000) |
		// contrasena
		vars.put("contrasena", js.executeScript("return \"HmisHmis\" + Math.floor(Math.random()*1500000)"));
		// 14 | type | id=contrasena | ${contrasena}
		driver.findElement(By.id("contrasena")).sendKeys(vars.get("contrasena").toString());
		// 15 | click | id=repetir-contrasena |
		driver.findElement(By.id("repetir-contrasena")).click();
		// 16 | type | id=repetir-contrasena | contrasenaMal
		driver.findElement(By.id("repetir-contrasena")).sendKeys("contrasenaMal");
		// 17 | click | id=botonContrasena |
		driver.findElement(By.id("botonContrasena")).click();
		// 19 | assertAlert | Las dos contrase??as no coinciden |
		assertEquals(driver.switchTo().alert().getText(), "Las dos contrase??as no coinciden");
		driver.switchTo().alert().accept();
		// 20 | click | linkText=CERRAR SESI??N |
		driver.findElement(By.linkText("CERRAR SESI??N")).click();
	}
}
