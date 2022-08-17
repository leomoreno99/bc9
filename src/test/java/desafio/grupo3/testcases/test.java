package desafio.grupo3.testcases;

import desafio.grupo3.pages.trenes.HomePageTrenes;
import desafio.grupo3.pages.trenes.ReservaPageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class test extends SeleniumTestBase
{
    HomePageTrenes homePageTrenes;
    ReservaPageTrenes reservaPageTrenes;
    @Test
    void PruebaHome(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        Assertions.assertEquals("Selecciona ciudad de origen y Selecciona ciudad de destino",homePageTrenes.entregaError());
    }
    @Test
    void PruebaReserva()
    {
        reservaPageTrenes = new ReservaPageTrenes(DriverFactory.getDriver());
        System.out.println(reservaPageTrenes.ValidacionErrorReserva());
        System.out.println(reservaPageTrenes.ValidacionErrorViaja());
        reservaPageTrenes.ValidacionCamposReserva("Brandon","Muñoz","brandon.munoz@gamil.cl","975786172");
        reservaPageTrenes.ValidacionCamposViaja("Brandon","Muñoz","3","9","2022");
    }
}
