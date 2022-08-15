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
}
