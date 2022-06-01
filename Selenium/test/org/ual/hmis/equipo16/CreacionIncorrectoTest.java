package org.ual.hmis.equipo16;

import static org.junit.Assert.assertEquals;

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

public class CreacionIncorrectoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
	    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
	    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void creacionIncorrecto() {
		// Test name: creacionIncorrecto
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://ecovivarenas.es/");
		// 2 | setWindowSize | 1552x840 |
		driver.manage().window().setSize(new Dimension(1552, 840));
		if (!driver.findElements(By.id("btn-aceptar-cookies")).isEmpty()) {
			driver.findElement(By.id("btn-aceptar-cookies")).click();
		}
		// 3 | click | id=carrito |
		driver.findElement(By.id("carrito")).click();
		// 4 | click | id=registrar |
		driver.findElement(By.id("registrar")).click();
		// 5 | runScript | window.scrollTo(0,129.60000610351562) |
		js.executeScript("window.scrollTo(0,129.60000610351562)");
		// 6 | click | id=nombre |
		driver.findElement(By.id("nombre")).click();
		// 7 | type | id=nombre | UserRandom
		driver.findElement(By.id("nombre")).sendKeys("UserRandom");
		// 8 | click | id=apellidos |
		driver.findElement(By.id("apellidos")).click();
		// 9 | type | id=apellidos | SurnameRandom
		driver.findElement(By.id("apellidos")).sendKeys("SurnameRandom");
		// 10 | click | id=correo |
		driver.findElement(By.id("correo")).click();
		// 11 | executeScript | return "ual-" + Math.floor(Math.random()*1500000)+"@u.s"
		// | emailrandom
		vars.put("emailrandom", js.executeScript("return \"ual-\" + Math.floor(Math.random()*1500000)+\"@u.s\""));
		// 12 | type | id=correo | ${emailrandom}
		driver.findElement(By.id("correo")).sendKeys(vars.get("emailrandom").toString());
		// 13 | click | id=repetir-correo |
		driver.findElement(By.id("repetir-correo")).click();
		// 14 | type | id=repetir-correo | ${emailrandom}
		driver.findElement(By.id("repetir-correo")).sendKeys(vars.get("emailrandom").toString());
		// 15 | click | id=contrasena |
		driver.findElement(By.id("contrasena")).click();
		// 16 | type | id=contrasena | Hmis2022
		driver.findElement(By.id("contrasena")).sendKeys("Hmis2022");
		// 17 | click | id=repetir-contrasena |
		driver.findElement(By.id("repetir-contrasena")).click();
		// 18 | type | id=repetir-contrasena | Hmis2022
		driver.findElement(By.id("repetir-contrasena")).sendKeys("Hmis2022");
		// 19 | click | id=enviar |
		driver.findElement(By.id("enviar")).click();
		// 20 | executeScript | return
		// document.getElementById("correo").validationMessage | message
		vars.put("message", js.executeScript("return document.getElementById(\"correo\").validationMessage"));
		// 21 | echo | ${message} |
		System.out.println(vars.get("message").toString());
		// 22 | assert | message | El correo debe ser válido
		assertEquals(vars.get("message").toString(), "El correo debe ser válido");
	}
}
