package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultidestinoPageVuelos extends SeleniumWrapper {

    public MultidestinoPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By inputOrigen1 = By.xpath("(//input[@data-test='SearchField-input'])[1]");
    By inputDestino1 = By.xpath("(//input[@data-test='SearchField-input'])[2]");
    By inputSalida1 = By.xpath("(//input[@data-test='SearchFieldDateInput'])[1]");
    By inputOrigen2 = By.xpath("(//input[@data-test='SearchField-input'])[3]");
    By inputDestino2 = By.xpath("(//input[@data-test='SearchField-input'])[4]");
    By inputSalida2 = By.xpath("(//input[@data-test='SearchFieldDateInput'])[2]");
}
