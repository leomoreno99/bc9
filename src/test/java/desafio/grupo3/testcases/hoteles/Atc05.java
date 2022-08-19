package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.hoteles.BusquedaPageHoteles;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import desafio.grupo3.pages.hoteles.ReservaHotelPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Atc05 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;
    BusquedaPageHoteles busquedaPageHoteles;
    ReservaHotelPage reservaHotelPage;

    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaHoteles();
    }

    @Test
    void reserva2Habitaciones() throws InterruptedException {
        homePageHoteles = new HomePageHoteles(DriverFactory.getDriver());
        homePageHoteles.ingresarDestino("Barcelona");
        homePageHoteles.ingresarFechas(8,26,8,31);
        homePageHoteles.reservaMultipleHabitacion();
        homePageHoteles.buscar();
        busquedaPageHoteles = new BusquedaPageHoteles(DriverFactory.getDriver());
        busquedaPageHoteles.seleccionarPrimero();
        busquedaPageHoteles.cambiarTab();
        reservaHotelPage = new ReservaHotelPage(DriverFactory.getDriver());

        Assertions.assertEquals(9, reservaHotelPage.elegiralojamiento());

    }

}
