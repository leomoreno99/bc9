package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.MultidestinoPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class atc02 extends SeleniumTestBase {
    HomePageRumbo homepagerumbo;
    HomePageVuelos homepagevuelos;
    MultidestinoPageVuelos multipagevuelos;

    @Test
    void validarForms(){
        int varIdaVuelta = 0;
        int varIda = 0;
        int varMulti = 0;
        int total = 0;
        homepagerumbo = new HomePageRumbo(DriverFactory.getDriver());
        homepagevuelos = new HomePageVuelos(DriverFactory.getDriver());
        multipagevuelos = new MultidestinoPageVuelos(DriverFactory.getDriver());
        homepagerumbo.navegarAlHome();
        homepagerumbo.aceptarCookies();
        homepagerumbo.navegarAPaginaVuelos();
        varIdaVuelta = homepagevuelos.comprobarFormularioIdaYVuelta("madrid");
        homepagevuelos.clickSoloIda();
        varIda = homepagevuelos.comprobarFormularioIda("madrid");
        homepagevuelos.clickMultidestino();
        homepagevuelos.cambiarTab();
        multipagevuelos.abrirOrigen1();
        multipagevuelos.abrirDestino1();
        multipagevuelos.abrirFecha1();
        multipagevuelos.abrirOrigen2();
        multipagevuelos.abrirDestino2();
        multipagevuelos.abrirFecha2();
        multipagevuelos.botonMasDestinos();
        multipagevuelos.abrirOrigen3();
        multipagevuelos.abrirDestino3();
        varMulti = multipagevuelos.abrirFecha3();
        total = varIdaVuelta+varIda+varMulti;

        Assertions.assertEquals(20,total);
    }
}
