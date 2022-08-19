package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class HomePageHoteles extends SeleniumWrapper {
    public HomePageHoteles(WebDriver driver) {
        super(driver);
    }

    //Locator

    By titleh4Locator = By.xpath("//div[@data-kind='hub-microsite-text']/descendant::h4/span");
    By alojamientoLocator = By.id("mui-1");
    By primeraOpcionAlojamientoLocator = By.id("mui-1-option-0");

    //Locator Habitacion 1
    By habitacionLocator = By.xpath("//div [@class = 'display-1j5hrwi']");
    By btnNinosMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[4]");
    By dropListEdadNinosLocator = By.xpath("//div[@class=\"display-1j5hrwi\"]/select");
    By btnAnadirHabitacionLocator = By.xpath("//div [@class = 'display-16gxy4x']/button");

    //Locator habitacion 2
    By btnSegundaAdultoMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[6]");
    By btnSegundaNinosMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[8]");

    By btnBuscarLocator = By.xpath("//div [@class = 'display-1jqt24b']/button");

    //localizadores ofertas
    By listadoOfertasTituloLocator = By.xpath("//a[@class=\"display-1jpjtw4-HubAnchor-styles e89md6u0\"]/descendant::h4[contains(text(),\"Hoteles en\")]");
    By listadoOfertasPrecioLocator = By.xpath("//a[@class=\"display-1jpjtw4-HubAnchor-styles e89md6u0\"]/descendant::p[@class=\"display-exp40l-HubFeatureCard-styled e1apqt30\"][contains(text(),\"Desde\")]");
    OfertasPageHoteles ofertasPageHoteles;
    private List<String> xpathsTitulos(){
        List<String> xpathOfertasTitulos = new ArrayList<>();
        List<WebElement> ofertas = findElements(listadoOfertasTituloLocator);
        for (int i=1; i<=ofertas.size();i++){
        String xpath = "(//a[@class=\"display-1jpjtw4-HubAnchor-styles e89md6u0\"]/descendant::h4[contains(text(),\"Hoteles en\")])["+i+"]";
        xpathOfertasTitulos.add(xpath);
        }

        return xpathOfertasTitulos;
    }
    private List<String> xpathsPrecios(){
        List<String> xpathOfertasPrecios = new ArrayList<>();
        List<WebElement> ofertas = findElements(listadoOfertasPrecioLocator);
        for (int i=1; i<=ofertas.size();i++){
            String xpath = "(//a[@class=\"display-1jpjtw4-HubAnchor-styles e89md6u0\"]/descendant::p[@class=\"display-exp40l-HubFeatureCard-styled e1apqt30\"][contains(text(),\"Desde\")])["+i+"]";
            xpathOfertasPrecios.add(xpath);
        }

        return xpathOfertasPrecios;
    }
    public String titleh4(){
        return getText(titleh4Locator);
    }
    private List<By> byArrayTitulos(){
        List<String> xpaths = xpathsTitulos();
        List<By> locatorsTitulos = new ArrayList<>();
        for (int i=0;i<xpaths.size();i++) {
            locatorsTitulos.add(By.xpath(xpaths.get(i)));
        }
        return locatorsTitulos;
    }
    private List<By> byArrayPrecios(){
        List<String> xpaths = xpathsPrecios();
        List<By> locatorsPrecios = new ArrayList<>();
        for (int i=0;i<xpaths.size();i++) {
            locatorsPrecios.add(By.xpath(xpaths.get(i)));
        }
        return locatorsPrecios;
    }
    public boolean obtenerTitulosyPrecios(HomePageHoteles driver){
        List<By> locatorsTitulos = byArrayTitulos();
        List<By> locatorsPrecios = byArrayPrecios();
        List<String> esperados = new ArrayList<>();
        List<String> resultados = new ArrayList<>();
        boolean test=true;
        String ciudad;
        String comparacion = "hoteles en ";
        String urlEsperada;
        ofertasPageHoteles = new OfertasPageHoteles(DriverFactory.getDriver());

        for(int i=0;i< locatorsTitulos.size();i++){
            String titulo = (getText(locatorsTitulos.get(i))).toLowerCase();
            ciudad = StringUtils.difference(comparacion,titulo);
            urlEsperada=ciudad+"?";
            String precio = (getText(locatorsPrecios.get(i))).toLowerCase();
            String esperado =  titulo +" "+ precio;
            esperados.add(esperado);
            click(locatorsTitulos.get(i));
            List<String> pestanas = driver.getTabsG3();
            driver.switchToG3(pestanas.get(pestanas.size()-1));
            String resultado= ofertasPageHoteles.resultado();
            String url= driver.getLinkG3();
            if(esperado.equals(resultado) && url.contains(urlEsperada)){resultados.add("true");}
            else {
                System.out.println("Revisar redirección " + titulo);
                resultados.add("false");
                test=false;
            }
            driver.closeWindowsG3();
            driver.switchToG3(pestanas.get(0));

        }
        return test;
    }
    public void ingresarDestino(String destino){
        write(destino,alojamientoLocator);
        click(primeraOpcionAlojamientoLocator);
    }
    private By webElementFecha(int mes, int dia){
        String xpath = "//div [@aria-labelledby = '"+ (mes-1) +"']/descendant::button[text()='"+dia+"']";
        return By.xpath(xpath);
    }
    public boolean ingresarFechas(int mesEntrada, int diaEntrada, int mesSalida, int diaSalida){
        if(mesEntrada>mesSalida || (mesEntrada==mesSalida&&diaEntrada>diaSalida)){
            System.out.println("Revisar ingreso de fechas, fecha de entrada mayor a entrada de salida");
            return false;
        }
        By fechaEntrada = webElementFecha(mesEntrada,diaEntrada);
        By fechaSalida = webElementFecha(mesSalida,diaSalida);
        if(isEnabled(fechaEntrada)){
            click(fechaEntrada);
        }
        if(isEnabled(fechaSalida)){
            click(fechaSalida);
        }
        return true;
    }

    public void habitaciones(){
        click(habitacionLocator);
    }
    public void buscar(){
        click(btnBuscarLocator);
    }

    public void reservaMultipleHabitacion(){
        click(btnAnadirHabitacionLocator);
        click(btnNinosMasLocator);
        click(btnNinosMasLocator);
        click(btnNinosMasLocator);
        click(btnSegundaAdultoMasLocator);
        click(btnSegundaAdultoMasLocator);
        click(btnSegundaNinosMasLocator);
        click(btnSegundaNinosMasLocator);
        ingresarNinos(8,10,11,10,11);
    }
    private void ingresarNinos(int a, int b, int c,int d, int e){
        ArrayList<Integer> edadesNinos = new ArrayList<Integer>();
        edadesNinos.add(a);
        edadesNinos.add(b);
        edadesNinos.add(c);
        edadesNinos.add(d);
        edadesNinos.add(e);
        List<WebElement> edades = findElements(dropListEdadNinosLocator);
        for(int i =0;i<edades.size();i++){
            Select dropDownSelect = new Select(edades.get(i));
            dropDownSelect.selectByValue(String.valueOf(edadesNinos.get(i)));
        }
    }
}
