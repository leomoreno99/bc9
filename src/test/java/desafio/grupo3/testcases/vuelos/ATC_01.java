package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ATC_01 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;

    @Test
    void redireccionIndex() throws InterruptedException {
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();
        homePageVuelos.llenarCamposIdaYVuelta("Madrid", "JFK", 9,3,9,6,2,0,0,"Turista Premium");
        Thread.sleep(5000);
        homePageVuelos.buscarVuelos();
        Thread.sleep(5000);
        Assertions.assertEquals("Vuelos baratos | Buscador de vuelos | Rumbo", homePageVuelos.getUrlTitle());
    }
}
