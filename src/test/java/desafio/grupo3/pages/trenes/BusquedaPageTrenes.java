package desafio.grupo3.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaPageTrenes extends SeleniumWrapper
{
    public BusquedaPageTrenes(WebDriver driver)
    {
        super(driver);
    }

    //Locator
    By filtroMejorLocator = By.xpath("(//li [@data-value = 'best_trip.asc'])[2]");
    By filtroBaratoLocator = By.xpath("(//li [@data-value = 'price.asc'])[2]");
    By filtroRapidoLocator = By.xpath("(//li [@data-value = 'duration.asc'])[2]");
    By resultTotalLocador = By.xpath("(//span [@class ='total-results-text']/strong)[1]");
    By filtroPrecioLocator = By.xpath("//div[@class='price-filter-container']/descendant::div[@class = 'noUi-handle noUi-handle-lower btn btn-default']");
    By filtroDuracionLocator = By.xpath("//div[@class='way-duration']/descendant::div[@class = 'noUi-handle noUi-handle-lower btn btn-default']");
    By filtroCompaniaLocator = By.name("providers-c1892");
    By filtroVariasCompaniaLocator = By.xpath("//div [@class = 'checkbox providers-filter-view__plus-company']/descendant::input");
    By btnLimpiarTodoLocator = By.xpath("//div [@class = 'col-xs-12']/button");
    By ingresarAlPrimeroLocator = By.xpath("(//div [@class = 'FullTripCard__PaymentContainer-sc-z8znd4-3 huUwCE'])[1]");
    By btnModificarLocator = By.xpath("//div[@class='search-summary__section search-summary__section--search']");
    By btnIdaVueltaLocator = By.xpath("//div [@data-type='round_trip']");
    By btnSoloIdaLocator = By.xpath("//div [@data-type='one_way']");
    By desplegableOrigenLocator = By.xpath("//div[text() = 'Origen']");
    By ciudadOrigenLocator = By.xpath("(//div[@data-value = 'MAD'])[1]");
    By desplegableDestinoLocator = By.xpath("//div[text() = 'Destino']");
    By ciudadDestinoLocator = By.xpath("(//div[@data-value = 'YJC'])[2]");
    By calendarioFechaIdaLocator = By.xpath("//div[@data-test = 'lmn-sw-cal-outbound']");
    By calendariFechaVueltaLocator = By.xpath("//div[@data-test = 'lmn-sw-cal-inbound']");
    By btnDiaIdaLocator = By.xpath("//div[@data-date = '20-7-2022']");
    By btnDiaVueltaLocator = By.xpath("//div[@data-date = '25-7-2022']");
    By desplegablePasajeroLocator = By.xpath("//div[@class = 'lmn-sw-passengers']/div");
    By btnMasAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[3])[1]");
    By btnMenosAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[1])[1]");
    By btnMasNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[3])[1]");
    By btnMenosNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[1])[1]");
    By btnBuscarLocator = By.xpath("//div[@data-test = 'lmn-sw-search-train']");


}
