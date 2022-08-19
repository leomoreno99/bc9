package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HomePageVuelos extends SeleniumWrapper {
    public HomePageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators

    By titleh4Locator = By.xpath("//div[@data-kind='hub-microsite-text']/descendant::h4/span");

    By btnIdaVueltaLocator = By.xpath("//div[text() = 'Ida y vuelta']"); // //div[@class='display-cz0mnt-ToggleGroup']/div[1]
    By btnSoloIdaLocator = By.xpath("//div[text() = 'Solo ida']"); // //div[@class='display-cz0mnt-ToggleGroup']/div[2]
    By btnMultidestino = By.xpath("//a[text() = 'Multidestino']");// //div[@class='display-cz0mnt-ToggleGroup']/a
    By inputOrigenLocator = By.id("mui-1");
    By listaCiudadesOrigenLocator = By.id("mui-1-listbox"); //Debe haber una busqueda con resultados
    By ciudadOrigenLocator = By.id("mui-1-option-0"); //Debe haber una busqueda con resultados, El ultimo numero corresponde a la posicion de la opcion
    By listaCiudadesDestinoLocator = By.id("mui-2-listbox");
    By inputDestinoLocator = By.id("mui-2");
    By ciudadDestinoLocator = By.id("mui-2-option-0");
    By containerCalendarioIdaLocator = By.className("display-1w4whnn-DateRangePicker-styled");
    By containerCalendarioVueltaLocator = By.className("display-1obvai8-DateRangePicker-styled");
    By calendarioFechaIdaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[1]");
    By calenarioFechaVueltaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[2]");
    //By btnDiaIdaLocator = By.xpath("(//button[text()='27'])[1]");
    //By btnDiaVueltaLocator = By.xpath("(//button[text()='13'])[2]"); //Funcionan de la misma manera dependiendo que calendario este desplegado.
    By desplegablePasajeroLocator = By.xpath("//span[text()='1 adulto']");
    By containerPasajerosLocator = By.className("display-19nsx8r");
    By btnMenosAdultosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[1]/button[1]"); //Podriamos hacer una lista e ir pasando por parametros el boton que queremos que presione
    By btnMasAdultosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[1]/button[2]");
    By btnMenosNinosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[2]/button[1]");
    By btnMasNinosLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[2]/button[2]");
    By btnMenosBebesLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[3]/button[1]");
    By btnMasBebesLocator = By.xpath("(//div[@class='display-ylvzma-Counter-styled'])[3]/button[2]");
    By desplegableClaseLocator = By.className("display-12cbrmg");
    By containerClaseLocator = By.className("display-1q6oxg9");
    //By claseLocator = By.xpath("//div[@class='display-1q6oxg9']/div[2]"); //Clase turista
    By btnBuscarLocator = By.xpath("(//button[text()='Buscar'])[1]"); //Podriamos buscar de esta manera las clases
    //By cardsContainerMejoresOfertasLocator = By.xpath("(//div[@class='hub-row e1pc4xpi0 display-xamolz-Row-styles-HubComponentsGrid e1sskiuc0'])[4]");
    By cardMadridLocator = By.xpath("(//div[@class='hub-row e1pc4xpi0 display-xamolz-Row-styles-HubComponentsGrid e1sskiuc0'])[4]/div[1]");

    By textoCalendarioIdaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[1]/span");
    By textoCalendarioVueltaLocator = By.xpath("//div[@class='display-1k2a5w2']/descendant::button[2]/span");
    By textoPasajeroLocator = By.xpath("(//span[@class='display-19d528r-Dropdown-styled-textOverflowEllipsis-Dropdown-styled'])[1]");
    By textoClaseLocator = By.xpath("//div[@class='display-12cbrmg']/descendant::span");


    public By generadorXpathFechas (int mes, int dia) {
        return By.xpath("//span[@id='" + (mes - 1) + "']/following-sibling::*/button[text()='" + dia + "']");
    }

    public By generadorXpathClase (String clase) {
        return By.xpath("//div[text()='" + clase + "']");
    }

    //Methods
    public void buscarIngresandoDestino(String textoDestino){
        ingresarDestino(textoDestino);
        buscarVuelos();
    }

    public void busquedaCompletaIdaYVuelta(String textoOrigen, String textoDestino, int mesIda, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase){
        ingresarOrigen(textoOrigen);
        ingresarDestino(textoDestino);
        ingresarFechas(mesIda, diaIda, mesVuelta, diaVuelta);
        ingresarPasajeros(adultos, ninos, bebes);
        elegirClase(clase);
        buscarVuelos();
    }

    public void llenarCamposIdaYVuelta(String textoOrigen, String textoDestino, int mesIda, int diaIda, int mesVuelta, int diaVuelta, int adultos, int ninos, int bebes, String clase){
        ingresarOrigen(textoOrigen);
        ingresarDestino(textoDestino);
        ingresarFechas(mesIda, diaIda, mesVuelta, diaVuelta);
        ingresarPasajeros(adultos, ninos, bebes);
        elegirClase(clase);
    }

    public void seleccionarOfertaMadrid(){
        click(cardMadridLocator);
    }

    public int comprobarFormularioIdaYVuelta(String text){
        int count = 0;
        count = probarOrigen(text, count);
        count = probarDestino(text, count);
        count = probarCalendarioIda(count);
        count = probarCalendarioVuelta(count);
        count = probarDesplegablePasajeros(count);
        count = probarDesplegableClase(count);

        return count;
    }

    public int comprobarFormularioIda(String text){
        int count = 0;
        clickSoloIda();
        count = probarOrigen(text, count);
        count = probarDestino(text, count);
        count = probarCalendarioVuelta(count);
        count = probarDesplegablePasajeros(count);
        count = probarDesplegableClase(count);

        return count;
    }

    public void clickSoloIda() {
        click(btnSoloIdaLocator);
    }

    public void clickMultidestino(){
        click(btnMultidestino);
    }

    public ArrayList<String> recogerDatosIngresados(){
        ArrayList<String> datos = new ArrayList<>();
        datos.add(findElement(inputOrigenLocator).getAttribute("value"));
        datos.add(findElement(inputDestinoLocator).getAttribute("value"));

        String text = getText(textoCalendarioIdaLocator);
        String text2 = getText(textoCalendarioVueltaLocator);

        /*text = datos.get(2).replaceAll("\\p{Punct}", "");
        text2 = datos.get(3).replaceAll("\\p{Punct}", "");*/

        datos.add(text.replaceAll("\\p{Punct}", ""));
        datos.add(text2.replaceAll("\\p{Punct}", ""));

        //datos.add(getText(textoCalendarioIdaLocator));
        //datos.add(getText(textoCalendarioVueltaLocator));
        datos.add(getText(textoPasajeroLocator));
        datos.add(getText(textoClaseLocator));


        return datos;
    }

    //Secondary methods

    private int probarDesplegableClase(int count) {
        click(desplegableClaseLocator);
        if(isDisplayed(containerClaseLocator))
            count += 1;
        return count;
    }

    private int probarDesplegablePasajeros(int count) {
        click(desplegablePasajeroLocator);
        if(isDisplayed(containerPasajerosLocator))
            count += 1;
        return count;
    }

    private int probarCalendarioVuelta(int count) {
        click(calendarioFechaIdaLocator);
        click(calenarioFechaVueltaLocator);
        if(isDisplayed(containerCalendarioVueltaLocator))
            count += 1;
        return count;
    }

    private int probarCalendarioIda(int count) {
        click(calendarioFechaIdaLocator);
        if(isDisplayed(containerCalendarioIdaLocator))
            count += 1;
        return count;
    }

    private int probarDestino(String text, int count) {
        click(inputDestinoLocator);
        write(text, inputDestinoLocator);
        if(isDisplayed(listaCiudadesDestinoLocator))
            count += 1;
        return count;
    }

    private int probarOrigen(String text, int count) {
        write("\b", inputOrigenLocator);
        click(inputOrigenLocator);
        write(text, inputOrigenLocator);
        if(isDisplayed(listaCiudadesOrigenLocator))
            count += 1;
        return count;
    }

    public void buscarVuelos() {
        click(btnBuscarLocator);
    }
    private void elegirClase(String clase) {
        click(desplegableClaseLocator);
        click(generadorXpathClase(clase));
    }

    private void ingresarPasajeros(int adultos, int ninos, int bebes) {
        for (int i = 0; i < adultos - 1; i++) {
            click(btnMasAdultosLocator);
        }
        for (int i = 0; i < ninos; i++) {
            click(btnMasNinosLocator);
        }
        for (int i = 0; i < bebes; i++) {
            click(btnMasBebesLocator);
        }
    }

    private void ingresarFechas(int mesIda, int diaIda, int mesVuelta, int diaVuelta) {
        click(generadorXpathFechas(mesIda, diaIda));
        click(generadorXpathFechas(mesVuelta, diaVuelta));
    }

    public String titleh4(){
        return getText(titleh4Locator);
    }

    private void ingresarDestino(String textoDestino) {
        write(textoDestino, inputDestinoLocator);
        click(ciudadDestinoLocator);
    }

    private void ingresarOrigen(String textoOrigen) {
        findElement(inputOrigenLocator).clear();
        write(textoOrigen, inputOrigenLocator);
        click(ciudadOrigenLocator);
    }

}
