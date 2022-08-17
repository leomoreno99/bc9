package desafio.grupo3.testcases;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.HomePageVuelos;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestPruebasLeo extends SeleniumTestBase {

    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;

    @ParameterizedTest
    @CsvSource({"Madrid,Ezeiza,8,23,8,29,4,2,1,Turista",
                "Cancún,Narita,9,1,9,5,3,1,2,Business"})
    //@Test
    void probarFunciones(String textoOrigen, String textoDestino, int mesDia, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();

        //homePageVuelos.buscarIngresandoDestino("Buenos Aires");
        homePageVuelos.busquedaCompletaIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        //homePageVuelos.seleccionarOfertaMadrid();
        //int count = homePageVuelos.comprobarFormularioIdaYVuelta("Buenos Aires");
        //int count2 = homePageVuelos.comprobarFormularioIda("Buenos Aires");
        //Assertions.assertEquals(6, count);
        //Assertions.assertEquals(11, count + count2);
    }
}
