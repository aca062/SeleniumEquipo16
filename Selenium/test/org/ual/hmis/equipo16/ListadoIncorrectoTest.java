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

public class ListadoIncorrectoTest {
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
    public void listadoIncorrecto() {
        // Test name: listadoIncorrecto
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://ecovivarenas.es/");
        // 2 | setWindowSize | 1552x840 |
        driver.manage().window().setSize(new Dimension(1552, 840));
        if (!driver.findElements(By.id("btn-aceptar-cookies")).isEmpty()) {
            driver.findElement(By.id("btn-aceptar-cookies")).click();
        }
        // 3 | click | linkText=Verduras |
        driver.findElement(By.linkText("Verduras")).click();
        // 4 | click | id=precioMenor |
        driver.findElement(By.id("precioMenor")).click();
        // 5 | type | id=precioMenor | 3
        driver.findElement(By.id("precioMenor")).sendKeys("3");
        // 6 | click | id=precioMayor |
        driver.findElement(By.id("precioMayor")).click();
        // 7 | type | id=precioMayor | 2
        driver.findElement(By.id("precioMayor")).sendKeys("2");
        // 8 | click | css=.filtro:nth-child(2) |
        driver.findElement(By.cssSelector(".filtro:nth-child(2)")).click();
        // 9 | assertElementNotPresent | css=.producto:nth-child(1) > .datosProducto
        // input:nth-child(1) |
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        {
            List<WebElement> elements = driver
                    .findElements(By.cssSelector(".producto:nth-child(1) > .datosProducto input:nth-child(1)"));
            assert (elements.size() == 0);
        }
        // 10 | assertElementNotPresent | css=.producto:nth-child(2) > .datosProducto
        // input:nth-child(1) |
        {
            List<WebElement> elements = driver
                    .findElements(By.cssSelector(".producto:nth-child(2) > .datosProducto input:nth-child(1)"));
            assert (elements.size() == 0);
        }
    }
}
