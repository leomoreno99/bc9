package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestDemo extends SeleniumTestBase {

    WebDriver driver;

    @Test
    @Description("Test creado para bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        driver = DriverFactory.getDriver();

        //Acciones del Browser

        //Navegacion basica del driver/browser
        /*driver.get(BASE_URL_AUT);
        obtenerDatosEImprimir();
        Thread.sleep(3000);

        driver.navigate().to("https://selenium.dev");
        Thread.sleep(3000);
        obtenerDatosEImprimir();

        //Browser :: Back - Fordward - Refresh
        driver.navigate().back();
        obtenerDatosEImprimir();

        driver.navigate().forward();
        obtenerDatosEImprimir();

        driver.navigate().refresh(); //F5*/


        // Ventanas y tabs. Como movernos
        /*String ventanaUno = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        String ventanaDos = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        String pestania = driver.getWindowHandle();
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventanaUno);
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventanaDos);
        driver.get(BASE_URL_AUT);*/


        //Dimensionamiento del browser
        //int alto = driver.manage().window().getSize().getHeight();
        //int ancho = driver.manage().window().getSize().getWidth();

        /*Dimension dimensionVentana = driver.manage().window().getSize();
        int alto = dimensionVentana.getHeight();
        int ancho = dimensionVentana.getWidth();

        driver.manage().window().setSize(new Dimension(800, 600));


        //Posisionamiento del browser
        Point posisionDriver = driver.manage().window().getPosition();
        int posisionX = posisionDriver.getX();
        int posisionY = posisionDriver.getY();

        driver.manage().window().setPosition(new Point(10, 10)); // tambien esta minimize, maximize y fullscreen*/


        //Envolver en capa de JavaScript
        driver.get(BASE_URL_AUT);

        WebElement btnSuerte = driver.findElement(By.name("btnI"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("console.log('Hola mundo')");
        js.executeScript("arguments[0].click()", btnSuerte);

        Assertions.assertTrue(true);
    }

    private void obtenerDatosEImprimir() {
        String tituloWeb;
        String nombreUrlActual;
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);
    }
}