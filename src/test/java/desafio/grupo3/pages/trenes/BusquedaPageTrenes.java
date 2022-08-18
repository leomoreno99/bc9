package desafio.grupo3.pages.trenes;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusquedaPageTrenes extends SeleniumWrapper
{

    public BusquedaPageTrenes(WebDriver driver)
    {
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
    public By generadorXpathClase (String clase)
    {
        return By.xpath("//div[@class='select-items']/div[text()='"+clase+"']");
    }
    public By generadorXpathUltimoPrecio () {

        int Guardar = Integer.parseInt(totalResultadoViajes());

        return By.xpath("(//span [@class = 'TripCardPrice__FinalPrice-sc-1d8mdrx-5 rCnqw Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM'])["+Guardar+"]");
    }
    public By generadorXpathUltimoHorario() {

        int Guardar = Integer.parseInt(totalResultadoViajes());
        Guardar = (Guardar*2)-1;
        return By.xpath("(//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div)["+Guardar+"]");
    }
    public By generadorXpathUltimoHorarioVuelta() {

        int Guardar = Integer.parseInt(totalResultadoViajes());
        Guardar = (Guardar*2);
        return By.xpath("(//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div)["+Guardar+"]");
    }
    By ordenMejorLocator = By.xpath("(//li [@data-value = 'best_trip.asc'])[2]");
    By ordenBaratoLocator = By.xpath("(//li [@data-value = 'price.asc'])[2]");
    By ordenRapidoLocator = By.xpath("(//li [@data-value = 'duration.asc'])[2]");
    By primerPreciosLocator = By.xpath("(//span [@class = 'TripCardPrice__FinalPrice-sc-1d8mdrx-5 rCnqw Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM'])[1]");
    By primerHorasLocator = By.xpath("(//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div)[1]");
    By segundoHorasLocator = By.xpath("(//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div)[2]");
    //By btnVerMasResultadosLocator = By.xpath("//button [@type='button' and contains(text(),'Ver más resultados')]");
    By totalLocator = By.xpath("(//span [@class ='total-results-text']/strong)[1]");
    By resultTotalLocator = By.xpath("(//span [@class ='total-results-text']/strong)[2]");

    By btnVerTodosLocator = By.xpath("(//a [@Class='total-results-view--reset_all js-reset'])[1]");
    By desplegableMetodoPagoLocator = By.xpath("//select [@class='form-control']");
    By btnPayPalLocator = By.xpath("//option [@value='95']");
    By btnLimpiarTodoLocator = By.xpath("//div [@class = 'col-xs-12']/button");

    By ingresarAlPrimeroLocator = By.xpath("(//div [@class = 'FullTripCard__PaymentContainer-sc-z8znd4-3 huUwCE'])[1]");

    By btnModificarLocator = By.xpath("//div[@class='search-summary__section search-summary__section--search']");
    By desplegarcualquierClaseLocator = By.xpath("(//div[text()='Cualquier clase'])[1]");
    By desplegableOrigenLocator = By.xpath("//div[text() = 'Origen']");

    By btnMasAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[3])[1]");
    //By btnMenosAdultoLocator = By.xpath("(//div[@data-type = 'adults']/descendant::div[1])[1]");
    By btnMasNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[3])[1]");
    //By btnMenosNinosLocator = By.xpath("(//div[@data-type = 'children']/descendant::div[1])[1]");
    By btnBuscarLocator = By.xpath("//div[@data-test = 'lmn-sw-search-train']");

    //Metodos

    public void ordenMejor()
    {
        click(ordenMejorLocator);
    }
    public void ordenBarato()
    {
        click(ordenBaratoLocator);
    }
    public void ordenRapido()
    {
        click(ordenRapidoLocator);
    }
    public void ingresarPrimerTren()
    {
        click(ingresarAlPrimeroLocator);
    }
    public void seleccionBtnModificar()
    {
        click(btnModificarLocator);
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


    public void ingresarClase(String clase)
    {
        click(desplegarcualquierClaseLocator);
        click(generadorXpathClase(clase));
    }
    public void buscar()
    {
        click(btnBuscarLocator);
    }
    public void desplegableMetdePago()
    {
        click(desplegableMetodoPagoLocator);
    }

    public void metodoPagoPaypal()
    {
        click(btnPayPalLocator);
    }
    public String resultadoTotal()
    {
        String resultado = getText(resultTotalLocator);
        String[] Particion = resultado.split(" ");
        String parte = Particion[0];
        String guardado="";
        guardado = parte;
        return guardado;
    }
    public  String totalResultadoViajes()
    {   //WebElement total = findElement(totalLocator);
        WebDriverWait exwait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        exwait.until(ExpectedConditions.presenceOfElementLocated(totalLocator));
        return getText(totalLocator);
    }
    public void btnLimpiarFiltro()
    {
        click(btnLimpiarTodoLocator);
    }
    public double primerPrecio()
    {
        String resultado = getText(primerPreciosLocator);
        String[] Particion = resultado.split(" ");
        String parte = Particion[0];
        double guardado=0;
        String aux = parte.replace(",",".");
        guardado = Double.parseDouble(aux);
        return guardado;
    }
    public double ultimoPrecio()  {
        String resultado = getText(generadorXpathUltimoPrecio());
        String[] Particion = resultado.split(" ");
        String parte1 = Particion[0];
        double guardado=0;
        String aux = parte1.replace(",",".");
        guardado = Double.parseDouble(aux);
        return guardado;
    }
    public double primerHorario()
    {
        String resultado = getText(primerHorasLocator);
        String[] Particion = resultado.split(" ");
        String[] parte = Particion[0].split("h");
        String[] parte2 = Particion[1].split("m");
        String aux = parte[0];
        String aux2 = parte2[0];
        String union = aux+"."+aux2;
        double guardado=0;
        guardado = Double.parseDouble(union);
        return guardado;
    }
    public double segundoHorario()
    {
        String resultado = getText(segundoHorasLocator);
        String[] Particion = resultado.split(" ");
        String[] parte = Particion[0].split("h");
        String[] parte2 = Particion[1].split("m");
        String aux = parte[0];
        String aux2 = parte2[0];
        String union = aux+"."+aux2;
        double guardado=0;
        guardado = Double.parseDouble(union);
        return guardado;
    }
    public double ultimoHorario()
    {
        String resultado = getText(generadorXpathUltimoHorario());
        String[] Particion = resultado.split(" ");
        String[] parte = Particion[0].split("h");
        String[] parte2 = Particion[1].split("m");
        String aux = parte[0];
        String aux2 = parte2[0];
        String union = aux+"."+aux2;
        double guardado=0;
        guardado = Double.parseDouble(union);
        return guardado;
    }
    public double segundoUltimoHorario()
    {
        String resultado = getText(generadorXpathUltimoHorarioVuelta());
        String[] Particion = resultado.split(" ");
        String[] parte = Particion[0].split("h");
        String[] parte2 = Particion[1].split("m");
        String aux = parte[0];
        String aux2 = parte2[0];
        String union = aux+"."+aux2;
        double guardado=0;
        guardado = Double.parseDouble(union);
        return guardado;
    }

    public String limpiarFiltro()
    {

        desplegableMetdePago();
        metodoPagoPaypal();
        if(resultadoTotal()!=totalResultadoViajes())
        {
            btnLimpiarFiltro();
        }
        WebElement total = findElement(btnVerTodosLocator);
        WebDriverWait exwait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        exwait.until(ExpectedConditions.invisibilityOf(total));
        return totalResultadoViajes();
    }
    public String modificarBusqueda(String origen,String destino, int diaIda,int mesIda,int diaVuelta,int mesVuelta,int numAdult, int numNinos,String clase)
    {
        seleccionBtnModificar();
        ingresarOrigen(origen);
        ingresarDestino(destino);
        fechaDeIda(diaIda,mesIda);
        fechaDeVuelta(diaVuelta,mesVuelta);
        anadirAdulto(numAdult);
        anadirANino(numNinos);
        ingresarClase(clase);
        buscar();
        return totalResultadoViajes();

    }

    public boolean MasBarato()
    {
        ordenBarato();
        if(primerPrecio()<ultimoPrecio())
        {
            return true;
        }

        return false;
    }
    public boolean MasRapido()
    {
        ordenRapido();
        if(primerHorario()<ultimoHorario())
        {
            return true;
        }

        return false;
    }
    public boolean MasElMejor()
    {
        double promedio;
        double promedioUltimo;
        promedio = (primerHorario()+segundoHorario())/2;
        promedioUltimo = (ultimoHorario()+segundoUltimoHorario())/2;
        if(primerPrecio()<ultimoPrecio())
        {
            if(promedio<promedioUltimo)
            {
                return true;
            }
        }

        return false;
    }

}
