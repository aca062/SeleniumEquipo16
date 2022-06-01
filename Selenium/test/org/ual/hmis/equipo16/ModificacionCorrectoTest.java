package org.ual.hmis.equipo16;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModificacionCorrectoTest {
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

        Boolean headless = true;

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
	public void modificacionCorrecto() {
		// Test name: modificacionCorrecto
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
		// 9 | click | id=ddown |
		driver.findElement(By.id("ddown")).click();
		// 10 | click | linkText=Frutas |
		driver.findElement(By.linkText("Frutas")).click();
		// 11 | click | css=.producto:nth-child(1) input:nth-child(1) |
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(1) input:nth-child(1)")));
		driver.findElement(By.cssSelector(".producto:nth-child(1) input:nth-child(1)")).click();
		// 12 | click | css=p:nth-child(1) |
		//driver.findElement(By.cssSelector("p:nth-child(1)")).click();
		// 13 | assertText | css=p:nth-child(1) | Precio: 8 €/Kg
		WebDriverWait wait1 = new WebDriverWait(driver,30);
        WebElement selectMensaje1 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p:nth-child(1)")));
        assertEquals(selectMensaje1.getText(),"Precio: 8 €/Kg");
		// 14 | click | linkText=ADMINISTRACIÓN |
		driver.findElement(By.linkText("ADMINISTRACIÓN")).click();
		// 15 | click | id=editarInventario |
		driver.findElement(By.id("editarInventario")).click();
		// 16 | click | id=buscar |
		driver.findElement(By.id("buscar")).click();
		// 17 | type | id=buscar | almendra
		driver.findElement(By.id("buscar")).sendKeys("almendra");
		// 18 | click | css=.producto:nth-child(5) > form > input:nth-child(2) |
		WebDriverWait wait2 = new WebDriverWait(driver,30);
        wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(5) > form > input:nth-child(2)")));
		driver.findElement(By.cssSelector(".producto:nth-child(5) > form > input:nth-child(2)")).click();
		// 19 | click | id=decimales |
		driver.findElement(By.id("decimales")).click();
		// 20 | type | id=decimales | 4
		driver.findElement(By.id("decimales")).clear();
		driver.findElement(By.id("decimales")).sendKeys("4");
		// 21 | click | id=guardar |
		driver.findElement(By.id("guardar")).click();
		// 22 | click | id=ddown |
		driver.findElement(By.id("ddown")).click();
		// 23 | click | linkText=Frutas |
		driver.findElement(By.linkText("Frutas")).click();
		// 24 | click | css=.producto:nth-child(1) input:nth-child(1) |
		WebDriverWait wait3 = new WebDriverWait(driver,30);
        wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(1) input:nth-child(1)")));
		driver.findElement(By.cssSelector(".producto:nth-child(1) input:nth-child(1)")).click();
		// 25 | click | css=p:nth-child(1) |
		//driver.findElement(By.cssSelector("p:nth-child(1)")).click();
		// 26 | assertText | css=p:nth-child(1) | Precio: 4 €/Kg
		WebDriverWait wait4 = new WebDriverWait(driver,30);
        WebElement selectMensaje4 = wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p:nth-child(1)")));
        assertEquals(selectMensaje4.getText(),"Precio: 4 €/Kg");
		// 27 | click | css=.producto |
		driver.findElement(By.cssSelector(".producto")).click();
		// 28 | click | id=ddown |
		driver.findElement(By.id("ddown")).click();
		// 29 | click | linkText=ADMINISTRACIÓN |
		driver.findElement(By.linkText("ADMINISTRACIÓN")).click();
		// 30 | click | id=editarInventario |
		driver.findElement(By.id("editarInventario")).click();
		// 31 | click | id=buscar |
		driver.findElement(By.id("buscar")).click();
		// 32 | type | id=buscar | almendra
		driver.findElement(By.id("buscar")).sendKeys("almendra");
		// 33 | click | css=.producto:nth-child(5) > .datosProducto input:nth-child(1) |
        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(5)")));
		driver.findElement(By.cssSelector(".producto:nth-child(5) > .datosProducto input:nth-child(1)")).click();
		// 34 | click | css=p:nth-child(1) |
		driver.findElement(By.cssSelector("p:nth-child(1)")).click();
		// 35 | assertText | css=p:nth-child(1) | Precio: 4 €/Kg
		assertThat(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(), is("Precio: 4 €/Kg"));
		// 36 | click | linkText=ADMINISTRACIÓN |
		driver.findElement(By.linkText("ADMINISTRACIÓN")).click();
		// 37 | click | id=editarInventario |
		driver.findElement(By.id("editarInventario")).click();
		// 38 | click | id=buscar |
		driver.findElement(By.id("buscar")).click();
		// 39 | type | id=buscar | almendra
		driver.findElement(By.id("buscar")).sendKeys("almendra");
		// 40 | click | css=.producto:nth-child(5) > form > input:nth-child(2) |
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".producto:nth-child(5)")));
		driver.findElement(By.cssSelector(".producto:nth-child(5) > form > input:nth-child(2)")).click();
		// 41 | click | css=.campos |
		driver.findElement(By.cssSelector(".campos")).click();
		// 42 | type | id=decimales | 8
		driver.findElement(By.id("decimales")).clear();
		driver.findElement(By.id("decimales")).sendKeys("8");
		// 43 | click | id=guardar |
		driver.findElement(By.id("guardar")).click();
		// 44 | click | linkText=CERRAR SESIÓN |
		driver.findElement(By.linkText("CERRAR SESIÓN")).click();
	}
}
