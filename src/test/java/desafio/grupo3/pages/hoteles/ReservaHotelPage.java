package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservaHotelPage extends SeleniumWrapper {
    public ReservaHotelPage(WebDriver driver) {super(driver);}
    By btnReserva = By.xpath("//button[contains(text(),\"Elegir tipo de alojamiento\")]");
    By btnPrimerDisponible = By.xpath("//*[@id=\"rooms\"]/descendant::button[contains(text(),\"Continuar”)][1]");

    //Resumen datos
    By hotelLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[2]/span[1]");
    By fechaLlegadaLocator = By.xpath("<li class=\"hotel-summary__date\" data-test=\"hotel-summary-checkin-date\">vie, 26 ago 2022</li>v");
    By fechaIdaLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/ul/li[2]");
    By cantidadHabitacionesLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[3]");
    By tipoAlojamientoLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[4]/div[1]");
    By cantidadNochesLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[4]/span[1]");
    By tipoRegimenLocator = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[4]/span[2]");
    By cantidadPersonas = By.xpath("//*[@id=\"sticky-summary__body\"]/div[1]/div/div/div/div/div[4]/div[2]");
    By precioTotalLocator = By.xpath("//*[@id=\"total-price\"]/div/div/div/span[2]/span");

    public void elegiralojamiento(){
        click(btnReserva);
        click(btnPrimerDisponible);
    }
}
