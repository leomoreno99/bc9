package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    By btnModificarLocator = By.className("search-summary__search");
    By desplegablePasajeroLocator = By.xpath("//div[@class = 'lmn-sw-passengers']/div/div");
    By desplegableClaseLocator = By.className("select-selected");

    By listaPreciosLocator = By.xpath("//div[@class='TripCardPrice__PriceWrapper-sc-1d8mdrx-1 gWgEuQ']/descendant::span[@size='20']");
    By btnSeleccionarVuelo = By.xpath("(//div[@class='FullTripCard__SelectedPriceContainer-sc-z8znd4-4 fpDjbd'])[1]");
    By btnVerTodosLocator = By.xpath("(//a [@Class='total-results-view--reset_all js-reset'])[1]");

    //Funciones
    public void elegirVuelo(){
        click(btnSeleccionarVuelo);
    }

    public ArrayList<String> recogerDatosVuelo(){
        ArrayList<String> datos = new ArrayList<>();
        click(btnModificarLocator);
        datos.add(getText(abrevCiudadOrigenLocator));
        datos.add(getText(abrevCiudadDestinoLocator));

        String text = getText(fechaIdaLocator);
        String text2 = getText(fechaVueltaLocator);

        datos.add(text.replaceAll("\\p{Punct}", ""));
        datos.add(text2.replaceAll("\\p{Punct}", ""));
        datos.add(getText(desplegablePasajeroLocator));
        datos.add(getText(desplegableClaseLocator));

        return datos;
    }

    public int comprarar(ArrayList<String> datos1, ArrayList<String> datos2){
        int cont = 0;

        for (int i = 0; i < datos1.size(); i++) {
            if(datos1.get(i).contains(datos2.get(i)))
                cont += 1;
        }

        return cont;
    }

    public void filtrarPecio(int movX, int movY){
        presionarMoverYSoltarG3(filtroPrecioLocator, movX, movY);
    }

    public void espera(){
        eWaitG3().until(ExpectedConditions.visibilityOf(findElement(btnVerTodosLocator)));
    }

    public boolean compararPrecios() {
        //Esperar
        boolean isMayor = true;
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
                isMayor = false;
        }
        return isMayor;
    }
}
