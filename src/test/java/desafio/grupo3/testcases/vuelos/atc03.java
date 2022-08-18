package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.BusquedaPageVuelos;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class atc03 extends SeleniumTestBase {
    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;
    BusquedaPageVuelos busquedaPageVuelos;

    @ParameterizedTest
    @CsvSource({"Cancún,Narita,9,1,9,5,3,1,2,Business","Madrid,Ezeiza,9,1,9,2,1,0,0,Turista"})
    void busquedaCorrecta(String textoOrigen, String textoDestino, int mesDia, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        busquedaPageVuelos = new BusquedaPageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();
        homePageVuelos.llenarCamposIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        ArrayList<String> datos1 = new ArrayList<>(homePageVuelos.recogerDatosIngresados());
        homePageVuelos.buscarVuelos();
        homePageVuelos.cambiarTab();
        ArrayList<String> datos2 = new ArrayList<>(busquedaPageVuelos.recogerDatosVuelo());
        Assertions.assertEquals(6, busquedaPageVuelos.comprarar(datos1, datos2));//podriamos hacer aqui lo de comprarar
    }
}
