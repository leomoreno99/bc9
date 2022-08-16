package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VuelosAPageVuelos extends SeleniumWrapper {
    public VuelosAPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By inputDestinoLocator = By.xpath("//label[text()='Destino']/following-sibling::div/input");
}
