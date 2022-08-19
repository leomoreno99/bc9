package desafio.grupo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultidestinoPageVuelos extends SeleniumWrapper {

    public MultidestinoPageVuelos(WebDriver driver) {
        super(driver);
    }

    //Locators

    By inputOrigen1 = By.xpath("//div[@data-test=\"SearchFieldItem-origin-0\"]");
    By inputDestino1 = By.xpath("(//input[@data-test='SearchField-input'])[2]");
    By inputSalida1 = By.xpath("(//input[@data-test='SearchFieldDateInput'])[1]");

    By inputOrigen2 = By.xpath("(//input[@data-test='SearchField-input'])[3]");
    By inputDestino2 = By.xpath("(//input[@data-test='SearchField-input'])[4]");
    By inputSalida2 = By.xpath("(//input[@data-test='SearchFieldDateInput'])[2]");
    By inputOrigen3 = By.xpath("//div[@data-test='SearchFieldItem-origin-2']");
    By inputDestino3 = By.xpath("//div[@data-test='SearchFieldItem-destination-2']");
    By inputSalida3 = By.xpath("(//input[@data-test=\"SearchFieldDateInput\"])[3]");

    By desplegable= By.xpath("//div[@class=\"PlacePickerstyled__StyledPlacePicker-sc-1ialbal-0 ceqpRV\"]");
    By inputCalendario = By.xpath("//div[@class=\"DatePickerstyled__DatePickerContainer-sc-tu2c5k-0 gyXyCP\"]");

    By btnMasDestinos = By.xpath("//button[@data-test=\"addMultiCity\"]");
    By btnCookies = By.xpath("//button[@id=\"cookies_accept\"]");


    int count=0;

    public void aceptarCookies(){
        click(btnCookies);
    }

    public int comprobarFormularioMultidestino(){
        abrirOrigen1();
        abrirDestino1();
        abrirFecha1();
        abrirOrigen2();
        abrirDestino2();
        abrirFecha2();
        botonMasDestinos();
        abrirOrigen3();
        abrirDestino3();
        abrirFecha3();

        return count;
    }
    public void abrirOrigen1(){
        click(inputOrigen1);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirDestino1(){
        click(inputDestino1);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirFecha1(){
        click(inputSalida1);
        if(isDisplayed(inputCalendario)){
            count++;
        }
    }
    public void abrirOrigen2(){
        click(inputOrigen2);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirDestino2(){
        click(inputDestino2);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirFecha2(){
        click(inputSalida2);
        if(isDisplayed(inputCalendario)){
            count++;
        }
    }
    public void abrirOrigen3(){
        click(inputOrigen3);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirDestino3(){
        click(inputDestino3);
        if(isDisplayed(desplegable)){
            count++;
        }
    }
    public void abrirFecha3(){
        click(inputSalida3);
        if(isDisplayed(inputCalendario)){
            count++;
        }
    }
    public void botonMasDestinos(){
        click(btnMasDestinos);
    }
}
