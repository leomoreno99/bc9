package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElegirPlanPageVuelos extends SeleniumWrapper {

    public ElegirPlanPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators
    By btnElegirClassicLocator = By.xpath("//div[text()='Elegir Classic']");
    By btnElegirFlexibleLocator = By.xpath("//div[text()='Elegir Flexible']");


}
