package desafio.grupo3.testcases.trenes;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.trenes.BusquedaPageTrenes;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATC_06 extends SeleniumTestBase
{

    HomePageRumbo homePageRumbo;
    HomePageTrenes homePageTrenes;
    BusquedaPageTrenes busquedaPageTrenes;

    @Test
    public void Limpiarfiltro(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",1,8,8,8,2,0);
        Assertions.assertEquals("9",busquedaPageTrenes.limpiarFiltro());
    }
}