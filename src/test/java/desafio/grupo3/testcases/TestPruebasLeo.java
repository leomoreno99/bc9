package desafio.grupo3.testcases;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TestPruebasLeo extends SeleniumTestBase {

    HomePageVuelos homePageVuelos;

    @Test
    void probarFunciones(){
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageVuelos.navegarAPaginaVuelos();
        homePageVuelos.buscarIngresandoDestino("Buenos Aires");
    }
}
