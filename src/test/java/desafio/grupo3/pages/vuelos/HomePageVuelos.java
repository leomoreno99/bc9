package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageVuelos extends SeleniumWrapper {
    public HomePageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators

    By btnIdaVueltaLocator = By.className("display-xi36x7-ToggleGroup-ToggleGroup"); // //div[text() = 'Ida y vuelta']
    By btnSoloIdaLocator = By.className("display-1i3exp5-ToggleGroup-ToggleGroup"); // //div[text() = 'Solo ida']
    By btnMultidestino = By.className("display-1h4wa6k-FlightTab-styled-ToggleGroup-ToggleGroup-FlightTab-styled"); // //a[text() = 'Multidestino']
    By desplegableOrigenLocator = By.id("mui-1");
    //By listaCiudadesOrigenLocator = By.id("mui-1-listbox"); //Debe haber una busqueda con resultados
    By ciudadOrigenLocator = By.id("mui-1-option-0"); //Debe haber una busqueda con resultados, El ultimo numero corresponde a la posicion de la opcion
    //By listaCiudadesDestinoLocator = By.id("mui-2-listbox");
    By ciudadDestinoLocator = By.id("mui-2-option-1");
    By calendarioFechaIdaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[1]");
    By calenarioFechaVueltaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[2]");
    By btnDiaIdaLocator = By.xpath("(//button[text()='27'])[1]");
    By btnDiaVueltaLocator = By.xpath("(//button[text()='13'])[2]"); //Funcionan de la misma manera dependiendo que calendario este desplegado.
    By desplegablePasajeroLocator = By.xpath("");
    By btnMenosAdultosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[1]/button[1]"); //Podriamos hacer una lista e ir pasando por parametros el boton que queremos que presione
    By btnMasAdultosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[1]/button[2]");
    By btnMenosNinosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[2]/button[1]");
    By btnMasNinosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[2]/button[2]");
    By btnMenosBebesLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[3]/button[1]");
    By btnMasBebesLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[3]/button[2]");
    By desplegableClaseLocator = By.className("display-12cbrmg");
    By claseLocator = By.xpath("//div[@class='display-1q6oxg9']/div[2]"); //Clase turista
    By btnBuscarLocator = By.xpath("(//button[text()='Buscar'])[1]"); //Podriamos buscar de esta manera las clases
 }
