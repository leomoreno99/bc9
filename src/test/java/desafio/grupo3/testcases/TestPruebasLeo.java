package desafio.grupo3.testcases;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TestPruebasLeo extends SeleniumTestBase {

    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;

    @Test
    void probarFunciones(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();


        homePageVuelos.busquedaCompletaIdaYVuelta("Madrid", "Buenos Aires");
    }
}
