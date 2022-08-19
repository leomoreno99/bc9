package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.BusquedaPageVuelos;
import desafio.grupo3.pages.vuelos.ElegirPlanPageVuelos;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.ReservaPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ATC_05 extends SeleniumTestBase {
    HomePageRumbo homepagerumbo;
    HomePageVuelos homepagevuelos;
    BusquedaPageVuelos busquedapagevuelos;
    ReservaPageVuelos reservapagevuelos;
    ElegirPlanPageVuelos elegirplanpagevuelos;

    @ParameterizedTest
    @CsvSource(value = {"Madrid-Ezeiza-9-1-9-2-1-0-0-Turista-jueves, 1 de septiembre, De Madrid a Buenos Aires, 15h 15m, Equipaje de mano incl., viernes, 2 de septiembre, De Buenos Aires a Madrid, 11h 45m, Turista",
                        "Madrid-JFK-9-3-9-6-2-0-0-Turista Premium-sábado, 3 de septiembre, De Madrid a Nueva York, 8h 10m, Turista Premium, martes, 6 de septiembre, De Nueva York a Madrid, 7h 20m, Turista Premium"},
                        delimiter = '-')
    void resumenReservas(String textoOrigen, String textoDestino, int mesDia, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase, String esperado) throws InterruptedException {
        homepagerumbo = new HomePageRumbo(DriverFactory.getDriver());
        homepagevuelos = new HomePageVuelos((DriverFactory.getDriver()));
        busquedapagevuelos = new BusquedaPageVuelos((DriverFactory.getDriver()));
        reservapagevuelos = new ReservaPageVuelos((DriverFactory.getDriver()));
        elegirplanpagevuelos = new ElegirPlanPageVuelos(DriverFactory.getDriver());
        homepagerumbo.navegarAlHome();
        homepagerumbo.aceptarCookies();
        homepagerumbo.navegarAPaginaVuelos();
        homepagevuelos.busquedaCompletaIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        homepagevuelos.cambiarTab();
        Thread.sleep(10000);
        busquedapagevuelos.elegirVuelo();
        Thread.sleep(10000);
        elegirplanpagevuelos.eligeFlex();
        reservapagevuelos.clickVerDetalles();
        Assertions.assertEquals(esperado,reservapagevuelos.comprobarDetalles());
        Assertions.assertTrue(reservapagevuelos.desgloseDisponible());
    }
}
