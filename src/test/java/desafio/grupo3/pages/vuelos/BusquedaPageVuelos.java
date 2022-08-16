package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaPageVuelos extends SeleniumWrapper {
    public BusquedaPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By filtroPrecioLocator = By.xpath("//div[@data-test='price']/descendant::div[@class='noUi-origin']/div");
    //By abrevCiudadOrigenLocator = By.className("search-summary__departure-place-code");
    //By abrevCiudadDestinoLocator = By.className("search-summary__arrival-place-code");
    By fechaIdaLocator = By.xpath("//div[@class='search-summary__date']/div[1]");
    By fechaVueltaLocator = By.xpath("//div[@class='search-summary__date']/div[3]");
    //By claseLocator = By.xpath("//div[@class='search-summary__class']/span");

    By inputOrigenLocator = By.id("input-k016t");
    By inputDestinoLocator = By.id("input-3ndtn");
    //By calendarioFechaIdaLocator = By.xpath("//div[@data-test='lmn-sw-cal-outbound']/div"); // No van
    //By calendarioFechaVueltaLocator = By.xpath("//div[@data-test='lmn-sw-cal-inbound']/div");
    By desplegablePasajeroLocator = By.xpath("//div[@class = 'lmn-sw-passengers']/div/div");
    By desplegableClaseLocator = By.className("select-selected");

    By listaResultadosLocator = By.xpath("//section[@data-role='results']");
    By btnSeleccionarVuelo = By.xpath("(//div[@class='FullTripCard__SelectedPriceContainer-sc-z8znd4-4 fpDjbd'])[1]");

    //Funciones
}
