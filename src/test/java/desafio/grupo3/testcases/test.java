package desafio.grupo3.testcases;

import desafio.grupo3.pages.trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class test extends SeleniumTestBase
{
    HomePageTrenes homePageTrenes;
    @Test
    void ClickDePrueba(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        homePageTrenes.BusquedaIdaYVuelta("Barcelona","Madrid",1,8,8,8,4,0);

    }
}
