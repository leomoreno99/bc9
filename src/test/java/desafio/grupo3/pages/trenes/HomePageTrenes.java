package desafio.grupo3.pages.trenes;

import com.beust.jcommander.Parameter;
import framework.engine.selenium.SeleniumWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    By btnIdaVueltaLocator = By.xpath("//div [@data-type='round_trip']");
    By btnSoloIdaLocator = By.xpath("//div [@data-type='one_way']");


    By desplegableOrigenLocator = By.xpath("//div[text() = 'Origen']");
    By errorOrigenLocator = By.xpath("//div [@class='validation-error']/div[1]");
    By errorDestinoLocator = By.xpath("//div [@class='validation-error']/div[2]");
    By btnHorarioMananaIdaLocator = By.xpath("(//div [@data-time='05-09'])[2]");
    By btnHorarioMedioDiaIdaLocator = By.xpath("(//div [@data-time='10-12'])[2]");
    By btnHorarioTardeIdaLocator = By.xpath("(//div [@data-time='13-17'])[2]");
    By btnHorarioTardeNocheIdaLocator = By.xpath("(//div [@data-time='18-22'])[2]");

    By btnHorarioMananaVueltaLocator = By.xpath("(//div [@data-time='05-09'])[1]");
    By btnHorarioMedioDiaVueltaLocator = By.xpath("(//div [@data-time='10-12'])[1]");
    By btnHorarioTardeVueltaLocator = By.xpath("(//div [@data-time='13-17'])[1]");
    By btnHorarioTardeNocheVueltaLocator = By.xpath("(//div [@data-time='18-22'])[1]");

    By btnMasAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[3])[1]");
    //By btnMenosAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[1])[1]");
    By btnMasNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[3])[1]");
   // By btnMenosNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[1])[1]");

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
    {
        click(desplegableOrigenLocator);
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
    public void horarioMananaVuelta()
    {
        click(btnHorarioMananaVueltaLocator);
    }
    public void horarioMedioDíaIda()
    {
        click(btnHorarioMedioDiaIdaLocator);
    }
    public void horarioMedioDíaVuelta()
    {
        click(btnHorarioMedioDiaVueltaLocator);
    }
    public void horarioTardeIda()
    {
        click(btnHorarioTardeIdaLocator);
    }
    public void horarioTardeVuelta()
    {
        click(btnHorarioTardeVueltaLocator);
    }
    public void horarioTardeNocheIda()
    {
        click(btnHorarioTardeNocheIdaLocator);
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
    public void BusquedaSoloIda(String origen,String destino, int diaIda,int mesIda,int numAdult, int numNinos)
    {
        soloIda();
        ingresarOrigen(origen);
        ingresarDestino(destino);
        horarioTardeIda();
        fechaDeIda(diaIda,mesIda);
        anadirAdulto(numAdult);
        anadirANino(numNinos);
        buscar();
    }
    public void errorOrigenDestino()
    {
        buscar();
        getText(errorOrigenLocator);
        getText(errorDestinoLocator);
    }

}
