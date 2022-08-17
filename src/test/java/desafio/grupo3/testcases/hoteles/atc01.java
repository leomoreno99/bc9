package desafio.grupo3.testcases.hoteles;


import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.hoteles.HomePageHoteles;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.*;

public class atc01 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;
    HomePageTrenes homePageTrenes;
    HomePageHoteles homePageHoteles;
    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
    }

    @Test
    void vuelos(){
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaVuelos();
        String tittle = homePageVuelos.getUrlTitle();
        String h4 = homePageVuelos.titleh4();
        Assertions.assertEquals("Vuelos baratos | Buscador de vuelos | Rumbo",tittle);
        Assertions.assertEquals("VUELOS", h4);
    }
    @Test
    void trenes(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        String tittle = homePageTrenes.getUrlTitle();
        String h4 = homePageTrenes.titleh4();
        Assertions.assertEquals("Billetes de tren | Billetes de AVE y Renfe baratos | Rumbo",tittle);
        Assertions.assertEquals("TRENES", h4);

    }
    @Test
    void hoteles(){
        homePageHoteles = new HomePageHoteles(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaHoteles();
        String tittle = homePageHoteles.getUrlTitle();
        String h4 = homePageHoteles.titleh4();
        Assertions.assertEquals("Hoteles | Ofertas de Hoteles baratos | Rumbo",tittle);
        Assertions.assertEquals("HOTELES", h4);

    }


}
