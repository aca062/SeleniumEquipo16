package org.ual.hmis.equipo16;

import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EliminarIncorrectoTest {
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
  public void eliminarIncorrecto() {
    // Test name: eliminarIncorrecto
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
    // 4 | click | id=registrar |
    driver.findElement(By.id("registrar")).click();
    // 5 | click | id=nombre |
    driver.findElement(By.id("nombre")).click();
    // 6 | type | id=nombre | UserRandom
    driver.findElement(By.id("nombre")).sendKeys("UserRandom");
    // 7 | type | id=apellidos | SurnameRandom
    driver.findElement(By.id("apellidos")).sendKeys("SurnameRandom");
    // 8 | executeScript | return "ual-" + Math.floor(Math.random()*1500000)+"@ual.es" | emailrandom
    vars.put("emailrandom", js.executeScript("return \"ual-\" + Math.floor(Math.random()*1500000)+\"@ual.es\""));
    // 9 | type | id=correo | ${emailrandom}
    driver.findElement(By.id("correo")).sendKeys(vars.get("emailrandom").toString());
    // 10 | click | id=correo |
    driver.findElement(By.id("correo")).click();
    // 11 | click | css=.campos > label:nth-child(4) |
    driver.findElement(By.cssSelector(".campos > label:nth-child(4)")).click();
    // 12 | click | id=repetir-correo |
    driver.findElement(By.id("repetir-correo")).click();
    // 13 | type | id=repetir-correo | ${emailrandom}
    driver.findElement(By.id("repetir-correo")).sendKeys(vars.get("emailrandom").toString());
    // 14 | click | id=contrasena |
    driver.findElement(By.id("contrasena")).click();
    // 15 | type | id=contrasena | HmisHmis2022
    driver.findElement(By.id("contrasena")).sendKeys("HmisHmis2022");
    // 16 | type | id=repetir-contrasena | HmisHmis2022
    driver.findElement(By.id("repetir-contrasena")).sendKeys("HmisHmis2022");
    // 17 | click | id=enviar |
    driver.findElement(By.id("enviar")).click();
    // 18 | click | css=.mensajeConfirmacion |
    //driver.findElement(By.cssSelector(".mensajeConfirmacion")).click();
    // 19 | verifyText | css=.mensajeConfirmacion | Se ha registrado correctamente\n\nVolver al inicio
    WebDriverWait wait = new WebDriverWait(driver,30);
    WebElement selectMensaje = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mensajeConfirmacion")));
    assertEquals(selectMensaje.getText(),"Se ha registrado correctamente\n\nVolver al inicio");
    // 20 | click | css=.mensajeConfirmacion |
    driver.findElement(By.cssSelector(".mensajeConfirmacion")).click();
    // 21 | click | id=atras |
    //driver.findElement(By.id("atras")).click();
    // 22 | click | id=carrito |
    driver.findElement(By.id("carrito")).click();
    // 23 | click | id=inicio-correo |
    driver.findElement(By.id("inicio-correo")).click();
    // 24 | type | id=inicio-correo | hmis@ual.es
    driver.findElement(By.id("inicio-correo")).sendKeys("hmis@ual.es");
    // 25 | click | id=inicio-contrasena |
    driver.findElement(By.id("inicio-contrasena")).click();
    // 26 | type | id=inicio-contrasena | HmisHmis2022
    driver.findElement(By.id("inicio-contrasena")).sendKeys("HmisHmis2022");
    // 27 | sendKeys | id=inicio-contrasena | ${KEY_ENTER}
    driver.findElement(By.id("inicio-contrasena")).sendKeys(Keys.ENTER);
    // 28 | click | linkText=ADMINISTRACIÓN |
    driver.findElement(By.linkText("ADMINISTRACIÓN")).click();
    // 29 | click | id=centroClientes |
    driver.findElement(By.id("centroClientes")).click();
    // 31 | click | css=.cliente:last-child input:nth-child(2) |
    driver.findElement(By.cssSelector(".cliente:last-child input:nth-child(2)")).click();
    // 32 | click | css=.cliente:last-child label:nth-child(3) |
    driver.findElement(By.cssSelector(".cliente:last-child label:nth-child(3)")).click();
    // 33 | assertElementPresent | xpath=//b[contains(.,'${emailrandom}')] |
    {
      List<WebElement> elements = driver.findElements(By.xpath("//b[contains(.,\'vars.get('emailrandom').toString()\')]"));
      assert(elements.size() > 0);
    }
    // 34 | click | linkText=CERRAR SESIÓN |
    driver.findElement(By.linkText("CERRAR SESIÓN")).click();
  }
}
