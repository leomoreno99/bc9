package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BusquedaPageHoteles extends SeleniumWrapper
{
    public BusquedaPageHoteles(WebDriver driver)
    {
        super(driver);
    }

    //Locator

    By btnTodosFiltrosLocator = By.xpath("//div [@class = 'styled__AllFiltersStyled-sc-1o4ryub-0 elBqKB active']");
    By btnCerrarTodosFiltrosLocator = By.xpath("//div [@class = 'styled__ModalFrameClose-sc-12zjd5z-1 hDaoLJ']");
    By btnEliminarTodosFiltrosLocator = By.xpath("//button [@class = 'styled__ResetOnTop-sc-18vcrz8-2 gQgRoD']");
    By mascotaLocator = By.xpath("//span[text()='Mascotas']");
    By spanMascota = By.xpath("//li[@class=\"AmenitiesSummary___StyledLi-sc-4545v1-2 zmHdy\"]/span");
    By btnAplicarLocator = By.xpath("//button [@class = 'styled__ApplyStyled-sc-18vcrz8-4 cHQYkF']");

    By ampliarMapaLocator = By.xpath("//div[@class='styled__ExpandMapContainer-sc-ukaj4w-5 iDCRmI']");
    By mapaMasZoomLocator = By.xpath("//button [@aria-label='Zoom in']");
    By mapaMenosZoomLocator = By.xpath("//button [@aria-label='Zoom out']");

    By ingresarPrimeraHotelLocator = By.xpath("//div [@class='styled__CardsGridStyled-sc-agrgbt-0 hvjdBK']/descendant::div[1]");

    By pinMapaLocator = By.xpath("//div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/div[1]");
    By mapaLocator = By.xpath("//canvas[@aria-label='Map']");
    By checkBuscarMapaLocator = By.xpath("//div[text()='Buscar al mover el mapa']");

    By nochesHotelLocator = By.xpath("(//span[@class='styled__FeatureText-sc-bdv6j3-1 bovErw'])[1]");

    public boolean todosLosFiltros() throws InterruptedException {
        Thread.sleep(4000);
        click(btnTodosFiltrosLocator);
        if(isDisplayed(btnCerrarTodosFiltrosLocator)){
            click(btnCerrarTodosFiltrosLocator);
            return true;
        }
        return false;
    }

    public void buscarMascotas() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        click(btnTodosFiltrosLocator);
        js.executeScript("arguments[0].scrollIntoView();", findElement(mascotaLocator));
        click(mascotaLocator);
        //presionarMoverYSoltarG3(mascotaLocator,0,0);
        click(btnAplicarLocator);
        Thread.sleep(4000);
        seleccionarPrimero();
    }

    public void seleccionarPrimero() throws InterruptedException {
        Thread.sleep(3000);
        click(ingresarPrimeraHotelLocator);
    }
    public boolean corroborarMascotas(){
       List<WebElement> array = findElements(spanMascota);
       String correcto = "Admite mascotas";
       for(int i=0;i< array.size();i++){
           if(array.get(i).getText().equals(correcto)){
               return true;
           }
       }
        return false;
    }

    public boolean probarBotonMas(){
        eWaitG3().until(ExpectedConditions.visibilityOf(findElement(checkBuscarMapaLocator)));
        String text = findElement(pinMapaLocator).getAttribute("style");
        click(mapaMasZoomLocator);
        String text2 = findElement(pinMapaLocator).getAttribute("style");
        return text.equals(text2);
    }

    public boolean probarBotonMenos(){
        eWaitG3().until(ExpectedConditions.visibilityOf(findElement(checkBuscarMapaLocator)));
        String text = findElement(pinMapaLocator).getAttribute("style");
        click(mapaMenosZoomLocator);
        String text2 = findElement(pinMapaLocator).getAttribute("style");
        return text.equals(text2);
    }

    public boolean scrollMas() {
        eWaitG3().until(ExpectedConditions.visibilityOf(findElement(checkBuscarMapaLocator)));
        String text = findElement(pinMapaLocator).getAttribute("style");
        WebElement mapa = findElement(mapaLocator);
        mapa.sendKeys(Keys.ADD);
        String text2 = findElement(pinMapaLocator).getAttribute("style");
        return text.equals(text2);
    }

    public boolean scrollMenos() {
        eWaitG3().until(ExpectedConditions.visibilityOf(findElement(checkBuscarMapaLocator)));
        String text = findElement(pinMapaLocator).getAttribute("style");
        WebElement mapa = findElement(mapaLocator);
        mapa.sendKeys(Keys.SUBTRACT);
        String text2 = findElement(pinMapaLocator).getAttribute("style");
        return text.equals(text2);
    }

    public void ampliarMapa(){
        click(ampliarMapaLocator);
    }

}
