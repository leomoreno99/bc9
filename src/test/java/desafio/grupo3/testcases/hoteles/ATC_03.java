package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.hoteles.BusquedaPageHoteles;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ATC_03 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;
    BusquedaPageHoteles busquedaPageHoteles;

    @Test
    void todosLosFiltros() throws InterruptedException {
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaHoteles();
        homePageHoteles = new HomePageHoteles(DriverFactory.getDriver());
        homePageHoteles.ingresarDestino("Barcelona");
        homePageHoteles.ingresarFechas(8,26,8,31);
        homePageHoteles.habitaciones();
        homePageHoteles.buscar();
        homePageHoteles.cambiarTab();
        busquedaPageHoteles = new BusquedaPageHoteles(DriverFactory.getDriver());
        Assertions.assertTrue(busquedaPageHoteles.todosLosFiltros());

    }
}
