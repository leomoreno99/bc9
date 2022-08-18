package desafio.grupo3.testcases.hoteles;

import desafio.grupo3.pages.HomePageRumbo;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Driver;

public class Atc02 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageHoteles homePageHoteles;
    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
    }

    @Test
    void masDeseados(){
        homePageHoteles =  new HomePageHoteles(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaHoteles();

    }

}
