package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.hoteles.OfertasPageHoteles;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Atc02 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;
    OfertasPageHoteles ofertasPageHoteles;
    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
    }

    @Test
    void masDeseados(){
        homePageHoteles =  new HomePageHoteles(DriverFactory.getDriver());
        ofertasPageHoteles = new OfertasPageHoteles(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaHoteles();
        homePageHoteles.obtenerTitulosyPrecios(homePageHoteles);


    }

}
