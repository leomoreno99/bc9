package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfertasPageHoteles extends SeleniumWrapper {
    public OfertasPageHoteles(WebDriver driver) {
        super(driver);
    }
    By h1OfertasLocator = By.xpath("//div[@Class=\"page-title\"]/h1");
    By precioOfertasLocator = By.xpath("//span[@class=\"title-price\"]");

    public String resultado(){
        return ((getText(h1OfertasLocator)).toLowerCase() +" "+ (getText(precioOfertasLocator)).toLowerCase());

    }
}
