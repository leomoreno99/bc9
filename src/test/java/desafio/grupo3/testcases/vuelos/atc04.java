package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.VuelosAPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;

public class atc04 extends SeleniumTestBase {
    HomePageRumbo homepagerumbo;
    HomePageVuelos homepagevuelos;
    VuelosAPageVuelos vuelosapagevuelos;
    @Test
    void vuelosMadrid(){
        homepagerumbo = new HomePageRumbo(DriverFactory.getDriver());
        homepagevuelos = new HomePageVuelos(DriverFactory.getDriver());
        vuelosapagevuelos = new VuelosAPageVuelos(DriverFactory.getDriver());
        homepagerumbo.navegarAlHome();
        homepagerumbo.aceptarCookies();
        homepagerumbo.navegarAPaginaVuelos();
        homepagevuelos.seleccionarOfertaMadrid();
        String resultado = vuelosapagevuelos.verifDestino();
        Assertions.assertEquals("Vuelos a Madrid", resultado);
    }
}
