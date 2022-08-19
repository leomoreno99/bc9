package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.hoteles.BusquedaPageHoteles;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Atc06 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;
    BusquedaPageHoteles busquedaPageHoteles;

    @Test
    void zoomMapa(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageHoteles = new HomePageHoteles(DriverFactory.getDriver());
        busquedaPageHoteles = new BusquedaPageHoteles(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaHoteles();

        homePageHoteles.ingresarDestino("Barcelona");
        homePageHoteles.ingresarFechas(8,26,8,31);
        homePageHoteles.buscar();
        homePageRumbo.cambiarTab();

        busquedaPageHoteles.ampliarMapa();

        boolean funciona = busquedaPageHoteles.probarBotonMas();
        boolean funciona2 = busquedaPageHoteles.probarBotonMenos();
        boolean funciona3 = busquedaPageHoteles.scrollMas();
        boolean funciona4 = busquedaPageHoteles.scrollMenos();

        Assertions.assertFalse(funciona);
        Assertions.assertFalse(funciona2);
        Assertions.assertFalse(funciona3);
        Assertions.assertFalse(funciona4);
    }
}
