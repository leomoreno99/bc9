package desafio.grupo3.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
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
}
