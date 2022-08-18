package desafio.grupo3.testcases;

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

public class TestPruebasLeo extends SeleniumTestBase {

    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;
    BusquedaPageVuelos busquedaPageVuelos;

    @ParameterizedTest
    @CsvSource({"Cancún,Narita,9,1,9,5,3,1,2,Business","Madrid,Mexico,9,1,9,2,1,0,0,Turista"})
    //@Test
    void probarFunciones(String textoOrigen, String textoDestino, int mesDia, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase) throws InterruptedException {
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        busquedaPageVuelos = new BusquedaPageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();

        //homePageVuelos.buscarIngresandoDestino("Ezeiza");
        //homePageVuelos.busquedaCompletaIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        //homePageVuelos.seleccionarOfertaMadrid();
        //int count = homePageVuelos.comprobarFormularioIdaYVuelta("Buenos Aires");
        //int count2 = homePageVuelos.comprobarFormularioIda("Buenos Aires");
        //Assertions.assertEquals(6, count);
        //Assertions.assertEquals(11, count + count2);

        //homePageVuelos.cambiarTab();
        //busquedaPageVuelos.elegirVuelo();
        //busquedaPageVuelos.recogerDatosVuelo();
        //busquedaPageVuelos.filtrarPecio(-155,0);
        //Thread.sleep(5000);
        //boolean res = busquedaPageVuelos.compararPrecios(); //Si es que son mayores a 2000
        //homePageVuelos.recogerDatosIngresados();
        homePageVuelos.llenarCamposIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        ArrayList<String> datos1 = new ArrayList<>(homePageVuelos.recogerDatosIngresados());
        homePageVuelos.buscarVuelos();
        homePageVuelos.cambiarTab();
        ArrayList<String> datos2 = new ArrayList<>(busquedaPageVuelos.recogerDatosVuelo());
        int result = busquedaPageVuelos.comprarar(datos1, datos2);
        Assertions.assertEquals(6, result);
    }
}
