package desafio.grupo3.pages.trenes;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTrenes extends SeleniumWrapper
{
    public HomePageTrenes(WebDriver driver) {
        super(driver);
    }

    //Locator

    public By generadorXpathOrigen (String ciudad)
    {
        return By.xpath("//div [text()= '"+ciudad+"']");
    }
    public By generadorXpathDestino (String ciudad)
    {
        return By.xpath("(//div [text()= '"+ciudad+"'])[2]");
    }
    public By generadorXpathFechaIdayVuelta (int dia,int mes)
    {
        return By.xpath("//div[@data-date = '"+dia+"-"+mes+"-2022']");
    }

    By titleh4Locator = By.xpath("//div[@data-kind='hub-microsite-text']/descendant::h4/span");
    By btnIdaVueltaLocator = By.xpath("//div [@data-type='round_trip']");
    By btnSoloIdaLocator = By.xpath("//div [@data-type='one_way']");


    By desplegableOrigenLocator = By.xpath("//div[text() = 'Origen']");
    By errorOrigenLocator = By.xpath("(//div [@class='validation-error']/div)[1]");
    By errorDestinoLocator = By.xpath("(//div [@class='validation-error']/div)[2]");
    By btnHorarioMananaIdaLocator = By.xpath("(//div [@data-time='05-09'])[2]");
    By btnHorarioTardeIdaLocator = By.xpath("(//div [@data-time='13-17'])[2]");
    By btnHorarioTardeNocheVueltaLocator = By.xpath("(//div [@data-time='18-22'])[1]");

    By btnMasAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[3])[1]");
    By btnMasNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[3])[1]");

    By btnBuscarLocator = By.xpath("//div[@data-test = 'lmn-sw-search-train']");

    //Metodos

    public void soloIda()
    {
        click(btnSoloIdaLocator);
    }
    public void idaYVuelta()
    {
        click(btnIdaVueltaLocator);
    }
    public void ingresarOrigen(String origen)
    {  WebElement ciuidad = findElement(generadorXpathOrigen(origen));
        click(desplegableOrigenLocator);
        WebDriverWait exwait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        exwait.until(ExpectedConditions.elementToBeClickable(ciuidad));
        click(generadorXpathOrigen(origen));
    }

    public void ingresarDestino(String destino)
    {
        click(generadorXpathDestino(destino));
    }

    public void fechaDeIda(int dia,int mes)
    {
        click(generadorXpathFechaIdayVuelta(dia,mes));
    }
    public void fechaDeVuelta(int dia,int mes)
    {
        click(generadorXpathFechaIdayVuelta(dia,mes));
    }
    public void horarioMananaIda()
    {
        click(btnHorarioMananaIdaLocator);
    }
    public void horarioTardeIda()
    {
        click(btnHorarioTardeIdaLocator);
    }
    public void horarioTardeNocheVuelta()
    {
        click(btnHorarioTardeNocheVueltaLocator);
    }
    public void anadirAdulto(int numAdult)
    {

        for(int i=1; i<numAdult;i++)
        {
            if(isDisplayed(btnMasAdultoLocator))
            {
                click(btnMasAdultoLocator);
            }
            else break;
        }
    }
    public void anadirANino(int numNino)
    {
        for(int i=0; i<numNino;i++)
        {
            if(isDisplayed(btnMasNinosLocator))
            {
                click(btnMasNinosLocator);
            }
            else break;
        }
    }
    public void buscar()
    {
        click(btnBuscarLocator);
    }
    public String errorOrigen()
    {
        return getText(errorOrigenLocator);
    }
    public String errorDestino()
    {
        return getText(errorDestinoLocator);
    }

    public void BusquedaIdaYVuelta(String origen,String destino, int diaIda,int mesIda,int diaVuelta,int mesVuelta,int numAdult, int numNinos)
    {
        idaYVuelta();
        ingresarOrigen(origen);
        ingresarDestino(destino);
        horarioMananaIda();
        fechaDeIda(diaIda,mesIda);
        horarioTardeNocheVuelta();
        fechaDeVuelta(diaVuelta,mesVuelta);
        anadirAdulto(numAdult);
        anadirANino(numNinos);
        buscar();
    }
    public String entregaError()
    {
        buscar();
        return errorOrigen()+" y " +errorDestino();
    }
    public String titleh4(){
        return getText(titleh4Locator);
    }


}
