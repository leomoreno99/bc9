package desafio.grupo3.pages;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class HomePageRumbo extends SeleniumWrapper {
    public HomePageRumbo(WebDriver driver) {
        super(driver);
    }

    //Locators
    By btnAceptarCookies = By.xpath("//button[@data-qa='oil-YesButton']");

    By btnVuelosLocator =By.xpath("(//a[@title='Vuelos'])[1]");
    By btnHotelesLocator =By.xpath("(//a[@title='Hoteles'])[1]");
    By btnTrenesLocator =By.xpath("(//a[@title='Trenes'])[1]");

    By btnResponsiveLocator = By.xpath("(//div[@class='display-5dfhaz-HubNavigationCta-styled ecnhbug0'])[4]");

    By responsiveTrenesLocator = By.xpath("(//div[@class='display-iu1hq3-MenuLink evvzyi81']/a[@title='Trenes'])[2]");
    //Methods
    public void aceptarCookies(){
        click(btnAceptarCookies);
    }

    public void navegarAPaginaVuelos(){
        click(btnVuelosLocator);
    }

    public void navegarAPaginaHoteles(){
        click(btnHotelesLocator);
    }

    public void navegarAPaginaTrenes(){
        click(btnTrenesLocator);
    }

    public void navegarAlHome(){
        navigateTo("https://www.rumbo.es/");
    }

    public void botonResponsive()
    {
        click(btnResponsiveLocator);
    }
    public void navegaraTrenes()
    {
        click(responsiveTrenesLocator);
    }
    public void navegarResponsiveTrenes()
    {
        Dimension AltoAncho = new Dimension(1023,700);
        DriverFactory.getDriver().manage().window().setSize(AltoAncho);
        botonResponsive();
        navegaraTrenes();
    }
}
