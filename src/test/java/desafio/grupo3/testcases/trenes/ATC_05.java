package desafio.grupo3.testcases.trenes;

import desafio.grupo3.pages.HomePageRumbo;
import desafio.grupo3.pages.trenes.BusquedaPageTrenes;
import desafio.grupo3.pages.trenes.HomePageTrenes;
import desafio.grupo3.pages.trenes.ReservaPageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATC_05 extends SeleniumTestBase
{

    HomePageRumbo homePageRumbo;
    HomePageTrenes homePageTrenes;
    BusquedaPageTrenes busquedaPageTrenes;
    ReservaPageTrenes reservaPageTrenes;

    @BeforeEach
    void setup(){
        homePageRumbo = new HomePageRumbo(DriverFactory.getDriver());
        homePageRumbo.navegarAlHome();
        homePageRumbo.aceptarCookies();
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        busquedaPageTrenes = new BusquedaPageTrenes(DriverFactory.getDriver());
        reservaPageTrenes = new ReservaPageTrenes(DriverFactory.getDriver());
        homePageRumbo.navegarAPaginaTrenes();
        homePageTrenes.BusquedaIdaYVuelta("Madrid","A Coruña",20,8,21,8,1,0);
        busquedaPageTrenes.ingresarPrimerTren();
    }

    @Test
    void ErrorCamposEmailyNumeroQuienReserva(){
        Assertions.assertEquals("Introduce un email válido y Introduce un número de teléfono válido",reservaPageTrenes.validarCampo("Nico","Figueroa"));
     }

    @Test
    void ErrorCamposNombreyApellidoQuienReserva(){
        Assertions.assertEquals("Introduce el nombre y Introduce el apellido",reservaPageTrenes.validarCampo2("Nico@mail.com","12345"));
    }
    @Test
    void ErrorFechaNacQuienViaja(){
        Assertions.assertEquals("Selecciona un título y Introduce la fecha de nacimiento (a partir de 12 años)",reservaPageTrenes.validarCampo3("Nico","Figueroa"));
    }
    @Test
    void Error(){
        Assertions.assertEquals("Introduce el nombre y Introduce el apellido",reservaPageTrenes.validarCampo4("8","9","1997"));
    }
}
