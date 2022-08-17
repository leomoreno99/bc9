package desafio.grupo3.testcases;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import desafio.grupo3.pages.vuelos.MultidestinoPageVuelos;
import desafio.grupo3.pages.vuelos.VuelosAPageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPruebaGino extends SeleniumTestBase{
    HomePageRumbo hpr;
    HomePageVuelos hpv;
    MultidestinoPageVuelos mpv;
    VuelosAPageVuelos vap;


    @Test
    void probarMulti(){
        int var = 0;
        hpr = new HomePageRumbo(DriverFactory.getDriver());
        hpv = new HomePageVuelos(DriverFactory.getDriver());
        mpv = new MultidestinoPageVuelos(DriverFactory.getDriver());
        hpr.navegarAlHome();
        hpr.aceptarCookies();
        hpr.navegarAPaginaVuelos();
        hpv.Multi();
       // mpv.cambiarTAB();
        //mpv.aceptarCookies();
        mpv.abrirOrigen1();
        mpv.abrirDestino1();
        mpv.abrirFecha1();
        mpv.abrirOrigen2();
        mpv.abrirDestino2();
        mpv.abrirFecha2();
        mpv.botonMasDestinos();
        mpv.abrirOrigen3();
        mpv.abrirDestino3();
        var = mpv.abrirFecha3();

        Assertions.assertEquals(9,var);

    }

    @Test
    void mejoresOfertas(){
        hpr = new HomePageRumbo(DriverFactory.getDriver());
        hpv = new HomePageVuelos(DriverFactory.getDriver());
        hpr.navegarAlHome();
        hpr.aceptarCookies();
        hpr.navegarAPaginaVuelos();
        hpv.ofertaMadrid();
        vap.verifDestino();
        Assertions.assertEquals("Madrid (MAD) Adolfo Suárez Barajas, España", vap.verifDestino());
    }
}


