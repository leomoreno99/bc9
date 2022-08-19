package desafio.grupo3.testcases.trenes;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.trenes.BusquedaPageTrenes;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATC_04 extends SeleniumTestBase
{

        HomePageRumbo homePageRumbo;
        HomePageTrenes homePageTrenes;
        BusquedaPageTrenes busquedaPageTrenes;

        @Test
        public void Modificarbusqueda(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",20,8,21,8,1,0);
        Assertions.assertEquals("56",busquedaPageTrenes.modificarBusqueda("Madrid","Barcelona",22,8,24,8,1,0,"Cualquier clase"));
        }
}
