package desafio.grupo3.testcases.trenes;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.trenes.BusquedaPageTrenes;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class atc01 extends SeleniumTestBase
{
    HomePageRumbo homePageRumbo;
    HomePageTrenes homePageTrenes;
    BusquedaPageTrenes busquedaPageTrenes;

    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
    }
    @Test
    public void filtradoElMejor()  {
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",20,8,21,8,1,0);
        Assertions.assertTrue(busquedaPageTrenes.MasElMejor());
    }
    @Test
    public void filtradoMasBarato() {
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",20,8,21,8,1,0);
        Assertions.assertTrue(busquedaPageTrenes.MasBarato());
    }
    @Test
    public void filtradoMasRapido() {
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",20,8,21,8,1,0);
        Assertions.assertTrue(busquedaPageTrenes.MasRapido());
    }


}
