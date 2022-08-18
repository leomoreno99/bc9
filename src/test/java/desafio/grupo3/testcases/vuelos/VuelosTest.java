package desafio.grupo3.testcases.vuelos;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.vuelos.*;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class VuelosTest extends SeleniumTestBase {

    HomePageRumbo homePageRumbo;
    HomePageVuelos homePageVuelos;
    BusquedaPageVuelos busquedaPageVuelos;
    ReservaPageVuelos reservaPageVuelos;
    ElegirPlanPageVuelos elegirPlanPageVuelos;
    MultidestinoPageVuelos multidestinoPageVuelos;
    VuelosAPageVuelos vuelosAPageVuelos;

    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageRumbo.navegarAPaginaVuelos();
    }

    @Test
    @Description("Pestaña principal no debe redireccionar luego de realizar búsqueda")
    void atc01() throws InterruptedException {
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        homePageVuelos.llenarCamposIdaYVuelta("Madrid", "JFK", 9,3,9,6,2,0,0,"Turista Premium");
        Thread.sleep(5000);
        homePageVuelos.buscarVuelos();
        Thread.sleep(5000);
        String title = homePageVuelos.getUrlTitle();
        Assertions.assertEquals("Vuelos baratos | Buscador de vuelos | Rumbo", title);
    }

    @Test
    void atc02(){
        int varIdaVuelta = 0;
        int varIda = 0;
        int varMulti = 0;
        int total = 0;
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        multidestinoPageVuelos = new MultidestinoPageVuelos(DriverFactory.getDriver());
        varIdaVuelta = homePageVuelos.comprobarFormularioIdaYVuelta("madrid");
        homePageVuelos.clickSoloIda();
        varIda = homePageVuelos.comprobarFormularioIda("madrid");
        homePageVuelos.clickMultidestino();
        homePageVuelos.cambiarTab();
        multidestinoPageVuelos.abrirOrigen1();
        multidestinoPageVuelos.abrirDestino1();
        multidestinoPageVuelos.abrirFecha1();
        multidestinoPageVuelos.abrirOrigen2();
        multidestinoPageVuelos.abrirDestino2();
        multidestinoPageVuelos.abrirFecha2();
        multidestinoPageVuelos.botonMasDestinos();
        multidestinoPageVuelos.abrirOrigen3();
        multidestinoPageVuelos.abrirDestino3();
        varMulti = multidestinoPageVuelos.abrirFecha3();
        total = varIdaVuelta+varIda+varMulti;

        Assertions.assertEquals(20,total);
    }

    @ParameterizedTest
    @CsvSource({"Cancún,Narita,9,1,9,5,3,1,2,Business","Madrid,Ezeiza,9,1,9,2,1,0,0,Turista"})
    void atc03(String textoOrigen, String textoDestino, int mesDia, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase){
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        busquedaPageVuelos = new BusquedaPageVuelos(DriverFactory.getDriver());
        homePageVuelos.llenarCamposIdaYVuelta(textoOrigen, textoDestino, mesDia, diaIda, mesVuelta, diaVuelta, adultos, ninos, bebes, clase);
        ArrayList<String> datos1 = new ArrayList<>(homePageVuelos.recogerDatosIngresados());
        homePageVuelos.buscarVuelos();
        homePageVuelos.cambiarTab();
        ArrayList<String> datos2 = new ArrayList<>(busquedaPageVuelos.recogerDatosVuelo());
        Assertions.assertEquals(6, busquedaPageVuelos.comprarar(datos1, datos2));//podriamos hacer aqui lo de comprarar
    }

    @Test
    void atc04(){
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        vuelosAPageVuelos = new VuelosAPageVuelos(DriverFactory.getDriver());
        homePageVuelos.seleccionarOfertaMadrid();
        homePageVuelos.cambiarTab();
        String resultado = vuelosAPageVuelos.verifDestino();
        Assertions.assertEquals("Vuelos a Madrid", resultado);
    }

    @Test
    void atc05() throws InterruptedException {
        String expected = "sábado, 3 de septiembre, De Madrid a Nueva York, 8h 10m, Turista Premium, martes, 6 de septiembre, De Nueva York a Madrid, 7h 20m, Turista Premium";
        homePageVuelos = new HomePageVuelos((DriverFactory.getDriver()));
        busquedaPageVuelos = new BusquedaPageVuelos((DriverFactory.getDriver()));
        reservaPageVuelos = new ReservaPageVuelos((DriverFactory.getDriver()));
        elegirPlanPageVuelos = new ElegirPlanPageVuelos(DriverFactory.getDriver());
        homePageVuelos.busquedaCompletaIdaYVuelta("Madrid", "JFK", 9,3,9,6,2,0,0,"Turista Premium");
        homePageVuelos.cambiarTab();
        Thread.sleep(10000);
        busquedaPageVuelos.elegirVuelo();
        Thread.sleep(10000);
        elegirPlanPageVuelos.eligeFlex();
        reservaPageVuelos.clickVerDetalles();
        Assertions.assertEquals(expected,reservaPageVuelos.comprobarDetalles());
        Assertions.assertTrue(reservaPageVuelos.desgloseDisponible());
    }

    @Test
    void atc06() throws InterruptedException {
        homePageVuelos = new HomePageVuelos(DriverFactory.getDriver());
        busquedaPageVuelos = new BusquedaPageVuelos(DriverFactory.getDriver());
        homePageVuelos.busquedaCompletaIdaYVuelta("Madrid", "Mexico", 9,1,9,2,1,0,0,"Turista");
        homePageVuelos.cambiarTab();
        busquedaPageVuelos.filtrarPecio(-159,0); //El problema es que tenemos que calcular bien los pixeles
        Thread.sleep(5000);
        Assertions.assertTrue(busquedaPageVuelos.compararPrecios());//Si es que son mayores a 2000
    }

}
