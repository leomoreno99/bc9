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
    By todosPreciosLocator = By.xpath("//span [@class = 'TripCardPrice__FinalPrice-sc-1d8mdrx-5 rCnqw Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']");
    By todasHorasLocator = By.xpath("//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div");

    By resultTotalLocador = By.xpath("(//span [@class ='total-results-text']/strong)[1]");
    By desplegableMetodoPagoLocator = By.xpath("//select [@class='form-control']");
    By btnPayPalLocator = By.xpath("//option [@value='95']");
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
