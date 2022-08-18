package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservaPageVuelos extends SeleniumWrapper {

    public ReservaPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By btnVerDetallesLocator = By.xpath("//button[@data-test='journey-details-link']");

    By fechaViajeIdaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroDate-sc-7wt6gl-2 bGnXnx'])[1]");
    By fechaViajeVueltaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroDate-sc-7wt6gl-2 bGnXnx'])[2]");
    By horaViajeIdaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__StyledHour-sc-1eo687l-10 dppCAB'])[1]");
    By horaViajeVueltaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__StyledHour-sc-1eo687l-10 dppCAB'])[3]");
    By ciudadesDesdeHaciaIdaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroSmallText-sc-7wt6gl-3 goNwye'])[1]");
    By ciudadesDesdeHaciaVueltaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroSmallText-sc-7wt6gl-3 goNwye'])[3]");
    By aeropuertoDesdeIdaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__MediumText-sc-1eo687l-6 jHESWa'])[1]");
    By aeropuertoHaciaIdaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__MediumText-sc-1eo687l-6 jHESWa'])[2]");
    By aeropuertoDesdeVueltaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__MediumText-sc-1eo687l-6 jHESWa'])[3]");
    By aeropuertoHaciaVueltaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__MediumText-sc-1eo687l-6 jHESWa'])[4]");
    By duracionVueloIdaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroSmallText-sc-7wt6gl-3 goNwye'])[2]/span[2]");
    By duracionVueloVueltaLocator = By.xpath("(//div[@class='JourneyDetailsWayIntro__WayIntroSmallText-sc-7wt6gl-3 goNwye'])[4]/span[2]");
    By claseIdaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__ProviderInfo-sc-1eo687l-12 hYszni'])[1]/div[4]");
    By claseVueltaLocator = By.xpath("(//div[@class='JourneyDetailsSegment__ProviderInfo-sc-1eo687l-12 hYszni'])[2]/div[4]");

    By btnMasDetallePrecioLocator = By.xpath("//span[@data-test='receipt-toggle-label']");
    By listaDesgosePreciosLocator = By.xpath("//ul[@data-test='receipt-cost-items']");
    By btnCerrarDetalle = By.xpath("//span[@data-testid=\"dialog-close-btn\"]");

    public void clickVerDetalles(){click(btnVerDetallesLocator);}

    public String comprobarDetalles(){
        String detalleTotal="";
        String detalleFechaida = "";
        String detalleFechaVuelta = "";
        String desdeHaciaIda="";
        String desdeHaciaVuelta="";
        String duracionVueloIda="";
        String duracionVueloVuelta="";
        String claseIda="";
        String claseVuelta="";


        if (isDisplayed(fechaViajeIdaLocator)){
           detalleFechaida = getText(fechaViajeIdaLocator);
           detalleFechaVuelta = getText(fechaViajeVueltaLocator);
           desdeHaciaIda = getText(ciudadesDesdeHaciaIdaLocator);
           desdeHaciaVuelta = getText(ciudadesDesdeHaciaVueltaLocator);
           duracionVueloIda = getText(duracionVueloIdaLocator);
           duracionVueloVuelta = getText(duracionVueloVueltaLocator);
           claseIda = getText(claseIdaLocator);
           claseVuelta = getText(claseVueltaLocator);

        }
        click(btnCerrarDetalle);
        detalleTotal = detalleFechaida+", "+desdeHaciaIda+", "+duracionVueloIda+", "+claseIda+", "+detalleFechaVuelta+", "+desdeHaciaVuelta+", "+duracionVueloVuelta+", "+claseVuelta;
        return detalleTotal;
    }

    public boolean desgloseDisponible(){
        boolean count= false;
        click(btnMasDetallePrecioLocator);
        if(isDisplayed(listaDesgosePreciosLocator)){
            count = true;
        }
        return count;
    }
}
