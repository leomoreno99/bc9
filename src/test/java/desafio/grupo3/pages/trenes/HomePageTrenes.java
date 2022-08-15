package desafio.grupo3.pages.trenes;

import com.beust.jcommander.Parameter;
import framework.engine.selenium.SeleniumWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTrenes extends SeleniumWrapper
{
    public HomePageTrenes(WebDriver driver) {
        super(driver);
    }

    //Locator

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

    //Metodos

    public void navegarAlHome()
    {
        navigateTo("https://www.rumbo.es/trenes/");
        click(btnSoloIdaLocator);
        click(btnIdaVueltaLocator);
        click(desplegableOrigenLocator);
        click(ciudadOrigenLocator);
        click(ciudadDestinoLocator);
        click(btnDiaIdaLocator);
        click(btnDiaVueltaLocator);
        click(btnMasAdultoLocator);
        click(btnMenosAdultoLocator);
        click(btnMasNinosLocator);
        click(btnMenosNinosLocator);
        click(btnBuscarLocator);
    }

}
