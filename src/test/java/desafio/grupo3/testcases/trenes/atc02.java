package desafio.grupo3.testcases.trenes;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class atc02 extends SeleniumTestBase
{
    HomePageRumbo homePageRumbo;
    HomePageTrenes homePageTrenes;
    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
    }
    @Test
    void responsive()
    {
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarResponsiveTrenes();
        Assertions.assertEquals("TRENES",homePageTrenes.titleh4());
    }
}
