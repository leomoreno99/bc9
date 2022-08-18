package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class BusquedaPageVuelos extends SeleniumWrapper {
    public BusquedaPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By filtroPrecioLocator = By.xpath("//div[@data-test='price']/descendant::div[@class='noUi-origin']/div");
    By abrevCiudadOrigenLocator = By.className("search-summary__departure-place-code");
    By abrevCiudadDestinoLocator = By.className("search-summary__arrival-place-code");
    By fechaIdaLocator = By.xpath("//div[@class='search-summary__date']/div[1]");
    By fechaVueltaLocator = By.xpath("//div[@class='search-summary__date']/div[3]");
    //By claseLocator = By.xpath("//div[@class='search-summary__class']/span");

    By btnModificarLocator = By.className("search-summary__search");
    By inputOrigenLocator = By.id("input-k016t");
    By inputDestinoLocator = By.id("input-3ndtn");
    //By calendarioFechaIdaLocator = By.xpath("//div[@data-test='lmn-sw-cal-outbound']/div"); // No van
    //By calendarioFechaVueltaLocator = By.xpath("//div[@data-test='lmn-sw-cal-inbound']/div");
    By desplegablePasajeroLocator = By.xpath("//div[@class = 'lmn-sw-passengers']/div/div");
    By desplegableClaseLocator = By.className("select-selected");

    By listaPreciosLocator = By.xpath("//div[@class='TripCardPrice__PriceWrapper-sc-1d8mdrx-1 gWgEuQ']/descendant::span[@size='20']");
    By btnSeleccionarVuelo = By.xpath("(//div[@class='FullTripCard__SelectedPriceContainer-sc-z8znd4-4 fpDjbd'])[1]");

    //Funciones
    public void elegirVuelo(){
        click(btnSeleccionarVuelo);
    }

    public void recogerDatosVuelo(){
        ArrayList<String> datos = new ArrayList<>();
        click(btnModificarLocator);
        datos.add(getText(fechaIdaLocator));
        datos.add(getText(fechaVueltaLocator));
        datos.add(getText(abrevCiudadOrigenLocator));
        datos.add(getText(abrevCiudadDestinoLocator));
        datos.add(getText(desplegablePasajeroLocator));
        datos.add(getText(desplegableClaseLocator));
    }

    public void filtrarPecio(int movX, int movY){
        presionarMoverYSoltarG3(filtroPrecioLocator, movX, movY);
    }

    public boolean compararPrecios() {
        //Esperar
        boolean isMayor = false;
        ArrayList<WebElement> preciosWebElement = new ArrayList<>(findElements(listaPreciosLocator));
        ArrayList<String> textPrecios = new ArrayList<>();
        ArrayList<Float> precios = new ArrayList<>();
        for (WebElement precio : preciosWebElement) {
            textPrecios.add(precio.getText());
        }
        for (String precio : textPrecios) {
            precios.add(Float.valueOf(precio.substring(0, precio.length() - 1).trim().replace(",", ".")));
        }
        for (int i = 0; i < precios.size(); i++) {
            if(precios.get(i) > 2000)
                isMayor = true;
        }
        return isMayor;
    }
}
