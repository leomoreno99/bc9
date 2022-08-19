package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATC_02 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;

    @Test
    void masDeseados(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageHoteles =  new HomePageHoteles(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaHoteles();
        Assertions.assertTrue(homePageHoteles.obtenerTitulosyPrecios(homePageHoteles));
    }

}
