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
    public By generadorXpathUltimoPrecio ()
    {

        int Guardar = Integer.parseInt(totalResultadoViajes());

        while (isDisplayed(btnVerMasResultadosLocator))
        {
            click(btnVerMasResultadosLocator);
        }

        return By.xpath("(//span [@class = 'TripCardPrice__FinalPrice-sc-1d8mdrx-5 rCnqw Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM'])["+Guardar+"]");

    }
    By ordenMejorLocator = By.xpath("(//li [@data-value = 'best_trip.asc'])[2]");
    By ordenBaratoLocator = By.xpath("(//li [@data-value = 'price.asc'])[2]");
    By ordenRapidoLocator = By.xpath("(//li [@data-value = 'duration.asc'])[2]");
    By primerPreciosLocator = By.xpath("(//span [@class = 'TripCardPrice__FinalPrice-sc-1d8mdrx-5 rCnqw Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM'])[1]");
    By todasHorasLocator = By.xpath("//span [@class = 'Tooltip___StyledMuiTooltip-sc-ya8k7d-3 jAgUJM']/parent::div");
    By btnVerMasResultadosLocator = By.xpath("//div [@class = 'col-sm-4 col-sm-offset-4 col-xs-12']/button");
    By totalLocator = By.xpath("(//span [@class ='total-results-text']/strong)[1]");
    By resultTotalLocator = By.xpath("(//span [@class ='total-results-text']/strong)[2]");
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
    {
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
    public double ultimoPrecio()
    {
        String resultado = getText(generadorXpathUltimoPrecio());
        String[] Particion = resultado.split(" ");
        String parte1 = Particion[0];
        double guardado=0;
        String aux = parte1.replace(",",".");
        guardado = Double.parseDouble(aux);
        return guardado;
    }

    public String limpiarFiltro()
    {
        String resultado,total;
        desplegableMetdePago();
        metodoPagoPaypal();
        if(resultadoTotal()!=totalResultadoViajes())
        {
            btnLimpiarFiltro();
        }
        else
        {
            return "filtro sin cambio";
        }
        return totalResultadoViajes();
    }
    public void modificarBusqueda(String origen,String destino, int diaIda,int mesIda,int diaVuelta,int mesVuelta,int numAdult, int numNinos,String clase)
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
    }
    public boolean MasBarato()
    {
        if(primerPrecio()<ultimoPrecio())
        {
            return true;
        }

        return false;
    }



}
