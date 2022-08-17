package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHoteles extends SeleniumWrapper {
    public HomePageHoteles(WebDriver driver) {
        super(driver);
    }

    //Locator

    By titleh4Locator = By.xpath("//div[@data-kind='hub-microsite-text']/descendant::h4/span");
    /*By alojamientoLocator = By.id("mui-1");
    By despleglabeAlojamientoLocator = By.id("mui-1-listbox");
    By primeraOpcionAlojamientoLocator = By.id("mui-1-option-0");
    By segundaOpcionAlojamientoLocator = By.id("mui-1-option-1");

    By btnCalendarioEntradaLocator = By.xpath("(//div [@class = 'display-pfh0xi']/button)[1]");
    By btnCalendarioSalidaLocator = By.xpath("(//div [@class = 'display-pfh0xi']/button)[2]");
    By btnDiaEntradaLocator = By.xpath("//div [@aria-labelledby = '7']/descendant::button[text()='22']");
    By btnDiaSalidaLocator = By.xpath("//div [@aria-labelledby = '7']/descendant::button[text()='25']");

    By pasajeroLocator = By.xpath("//div [@class = 'display-1j5hrwi']");
    By btnAdultoMenosLocarto = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[1]");
    By btnAdultoMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[2]");
    By btnNinosMenosLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[3]");
    By btnNinosMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[4]");

    By btnAnadirHabitacionLocator = By.xpath("//div [@class = 'display-16gxy4x']/button");

    //Locator habitacion 2
    By btnSegundaAdultoMenosLocarto = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[5]");
    By btnSegundaAdultoMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[6]");
    By btnSegundaNinosMenosLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[7]");
    By btnSegundaNinosMasLocator = By.xpath("(//div [@class = 'display-ylvzma-Counter-styled']/button)[8]");

    By btnBuscarLocator = By.xpath("//div [@class = 'display-1jqt24b']/button");


    //Locator Hoteles mas Deseados

    By hotelesMadridLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[1]");
    By hotelesMadridValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[2]");

    By hotelesBarcelonaLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[2]");
    By hotelesBarcelonaValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[4]");

    By hotelesValenciaLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[3]");
    By hotelesValenciaValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[6]");

    By hotelesGranadaLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[4]");
    By hotelesGranadaValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[8]");

    By hotelesAndorraLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[5]");
    By hotelesAndorraValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[10]");

    By hotelesIbizaLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::a[6]");
    By hotelesIbizaValorLocator = By.xpath("(//div [@class = 'hub-col-md-12 hub-col-12 hub-col display-1l4c07p-Column-styles-Column-styles e1i8mjyc0'])[8]/descendant::p[12]");*/

    public String titleh4(){
        return getText(titleh4Locator);
    }
}
