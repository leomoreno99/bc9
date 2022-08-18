package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.BusquedaPageVuelos;
import desafio.grupo3.pages.vuelos.ElegirPlanPageVuelos;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.ReservaPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;

public class Atc05 extends SeleniumTestBase {
    HomePageRumbo homepagerumbo;
    HomePageVuelos homepagevuelos;
    BusquedaPageVuelos busquedapagevuelos;
    ReservaPageVuelos reservapagevuelos;
    ElegirPlanPageVuelos elegirplanpagevuelos;

    @Test
    void reservas() throws InterruptedException {
        homepagerumbo = new HomePageRumbo(DriverFactory.getDriver());
        homepagevuelos = new HomePageVuelos((DriverFactory.getDriver()));
        busquedapagevuelos = new BusquedaPageVuelos((DriverFactory.getDriver()));
        reservapagevuelos = new ReservaPageVuelos((DriverFactory.getDriver()));
        elegirplanpagevuelos = new ElegirPlanPageVuelos(DriverFactory.getDriver());
        homepagerumbo.navegarAlHome();
        homepagerumbo.aceptarCookies();
        homepagerumbo.navegarAPaginaVuelos();
        homepagevuelos.busquedaCompletaIdaYVuelta("Madrid", "JFK", 9,3,9,6,2,0,0,"Turista Premium");
        homepagevuelos.cambiarTab();
        Thread.sleep(10000);
        busquedapagevuelos.elegirVuelo();
        Thread.sleep(10000);
        elegirplanpagevuelos.eligeFlex();
        reservapagevuelos.clickVerDetalles();
        Assertions.assertEquals("sábado, 3 de septiembre, De Madrid a Nueva York, 8h 10m, Turista Premium, martes, 6 de septiembre, De Nueva York a Madrid, 7h 20m, Turista Premium",reservapagevuelos.comprobarDetalles());
        Assertions.assertTrue(reservapagevuelos.desgloseDisponible());
    }
}
