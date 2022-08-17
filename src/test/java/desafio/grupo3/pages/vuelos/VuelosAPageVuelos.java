package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VuelosAPageVuelos extends SeleniumWrapper {
    public VuelosAPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    //By inputDestinoLocator = By.xpath("//label[text()='Destino']/following-sibling::div/input");
    By inputDestinoLocator = By.xpath("(//div[@class=\"lmn-sw-input-responsive--light\"])[2]");
    By inputHeaderLocator = By.xpath("//h1[@class=\"hero__title\"]");


    public String verifDestino() {
        //click(inputDestinoLocator);
        String Destino = getText(inputHeaderLocator);

        return Destino;
    }


}
