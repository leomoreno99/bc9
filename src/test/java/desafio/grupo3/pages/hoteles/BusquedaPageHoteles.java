package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
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
    By mascotaLocator = By.id("exp_elem_facilities_1");
    By btnAplicarLocator = By.xpath("//button [@class = 'styled__ApplyStyled-sc-18vcrz8-4 cHQYkF']");

    By ampliarMapaLocator = By.xpath("//div[@class='styled__ExpandMapContainer-sc-ukaj4w-5 iDCRmI']");
    By mapaMasZoomLocator = By.xpath("//button [@aria-label='Zoom in']");
    By mapaMenosZoomLocator = By.xpath("//button [@aria-label='Zoom out']");

    By ingresarPrimeraHotelLocator = By.xpath("//div [@class='styled__CardsGridStyled-sc-agrgbt-0 hvjdBK']/descendant::div[1]");

    public boolean todosLosFiltros() throws InterruptedException {
        Thread.sleep(4000);
        click(btnTodosFiltrosLocator);
        if(isDisplayed(btnCerrarTodosFiltrosLocator)){
            click(btnCerrarTodosFiltrosLocator);
            return true;
        }
        return false;
    }
}
