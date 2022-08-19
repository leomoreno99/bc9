package desafio.grupo3.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ReservaHotelPage extends SeleniumWrapper {
    public ReservaHotelPage(WebDriver driver) {super(driver);}
    By btnReserva = By.xpath("//button[contains(text(),\"Elegir tipo de alojamiento\")]");
    By btnPrimerDisponible = By.xpath("/html/body/div[2]/div[4]/section[1]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[2]/button");
    By nombreHotel = By.xpath("//h1");
    By precioHotel = By.xpath("//div[@data-testid='room-price']");
    By tipoAlojamientoHotel = By.xpath("//span[@class='RoomPanel___StyledSpan2-sc-szpnyn-13 dDDBMS']");
    By regimenHotel = By.xpath("//span[@data-testid='meal-plan-name']");
    By fechaEntrada = By.xpath("//div[@class='HotelCheckInCheckOut___StyledDiv2-sc-13eapzc-1 dtxywA']");
    By fechaSalida = By.xpath("//div[@class='HotelCheckInCheckOut___StyledDiv3-sc-13eapzc-3 hvuAfn']");
    By cantidadNoches = By.xpath("//div[@data-testid='price-type-container']/span");
    By cantidadAdultos = By.xpath("(//span[@class='SearchSummary__SummaryItem-sc-x3qpvg-1 fWPeaM'])[2]");
    By cantidadNinos = By.xpath("(//span[@class='SearchSummary__SummaryItem-sc-x3qpvg-1 fWPeaM'])[3]");
    By cantidadHabitaciones = By.xpath("//span[@class='RoomPanel___StyledSpan-sc-szpnyn-12 cYbhgz']");

    //Resumen datos
    By hotelLocator = By.xpath("//span[@data-test='hotel-summary-name']");
    By fechaLlegadaLocator = By.xpath("//li[@data-test='hotel-summary-checkin-date']");
    By fechaIdaLocator = By.xpath("//li[@data-test='hotel-summary-checkout-date']");
    By cantidadHabitacionesLocator = By.xpath("//div[@data-test='hotel-summary-rooms-count']");
    By tipoAlojamientoLocator = By.xpath("//div[@data-test='hotel-summary-room-description']");
    By cantidadNochesLocator = By.xpath("//span[@data-test='hotel-summary-stay-duration']");
    By tipoRegimenLocator = By.xpath("//span[@data-test='hotel-summary-mealplan']");
    By cantidadPersonas = By.xpath("//div[@data-test='hotel-summary-travellers-count']");
    By precioTotalLocator = By.xpath("//span[@data-test='currency-amount']");

    public int elegiralojamiento() throws InterruptedException {
        click(btnReserva);
        ArrayList<String> esperado = new ArrayList<>(recogerDatos());
        click(btnPrimerDisponible);
        Thread.sleep(6000);
        ArrayList<String> resultado = new ArrayList<>(recogerResultado());
        return comprarar(esperado, resultado);
    }

    public ArrayList<String> recogerDatos(){
        ArrayList<String> datos = new ArrayList<>();
        datos.add(getText(nombreHotel).toLowerCase());

        String fechaE = getText(fechaEntrada);
        String fechaS = getText(fechaSalida);

        datos.add(fechaE.replaceAll("\\p{Punct}", " "));
        datos.add(fechaS.replaceAll("\\p{Punct}", " "));

        String cantHab = getText(cantidadHabitaciones).toLowerCase();

        datos.add(cantHab.replaceAll("x", ""));
        datos.add(getText(tipoAlojamientoHotel).toLowerCase());

        String noches = StringUtils.difference("Precio total: 2 habitaciones, ",getText(cantidadNoches).toLowerCase());

        datos.add(noches);
        datos.add(getText(regimenHotel).toLowerCase());
        String personas = getText(cantidadAdultos).toLowerCase()+ " adultos + "+getText(cantidadNinos).toLowerCase()+" niños";
        datos.add(personas);
        datos.add(getText(precioHotel).toLowerCase());

        return datos;
    }

    public ArrayList<String> recogerResultado(){
        ArrayList<String> datos = new ArrayList<>();
        datos.add(getText(hotelLocator).toLowerCase());
        String fechaE = getText(fechaLlegadaLocator).toLowerCase();
        String fechaS = getText(fechaIdaLocator).toLowerCase();

        datos.add(fechaE.replaceAll("2022", "").replaceAll("\\p{Punct}", ""));
        datos.add(fechaS.replaceAll("2022", "").replaceAll("\\p{Punct}", ""));
        datos.add(getText(cantidadHabitacionesLocator).toLowerCase());
        datos.add(getText(tipoAlojamientoLocator).toLowerCase());
        datos.add(getText(cantidadNochesLocator).toLowerCase());
        datos.add(getText(tipoRegimenLocator).toLowerCase());
        datos.add(getText(cantidadPersonas).toLowerCase());

        String precio = getText(precioTotalLocator).toLowerCase();

        datos.add(precio.replaceAll(",00", ""));

        return datos;
    }

    public int comprarar(ArrayList<String> datos1, ArrayList<String> datos2){
        int cont = 0;

        for (int i = 0; i < datos1.size(); i++) {
            if(datos1.get(i).contains(datos2.get(i)))
                cont += 1;
        }

        return cont;
    }
}
