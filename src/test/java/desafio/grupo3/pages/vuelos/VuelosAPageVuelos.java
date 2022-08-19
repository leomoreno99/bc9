package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VuelosAPageVuelos extends SeleniumWrapper {
    public VuelosAPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By inputHeaderLocator = By.xpath("//h1[@class=\"hero__title\"]");


    public String verifDestino() {
        String Destino = getText(inputHeaderLocator);

        return Destino;
    }


}
