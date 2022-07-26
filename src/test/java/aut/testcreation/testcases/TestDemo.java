package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestDemo extends SeleniumTestBase {

    WebDriver driver;

    @Test
    @Description("Test creado para bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        driver = DriverFactory.getDriver();

        //Acciones del Browser
        driver.get(BASE_URL_AUT);
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

        driver.navigate().refresh(); //F5



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