package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.MultidestinoPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATC_02 extends SeleniumTestBase {
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
        varIdaVuelta = homepagevuelos.comprobarFormularioIdaYVuelta("Madrid");
        homepagevuelos.clickSoloIda();
        varIda = homepagevuelos.comprobarFormularioIda("Madrid");
        homepagevuelos.clickMultidestino();
        homepagevuelos.cambiarTab();
        varMulti = multipagevuelos.comprobarFormularioMultidestino();
        total = varIdaVuelta + varIda + varMulti;

        Assertions.assertEquals(20,total);
    }
}
