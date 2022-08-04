package aut.testcreation.pages;

import aut.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class GoogleHomePage extends SeleniumWrapper {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //Declarar los locators de esta pagina
    By barraBusquedaLocator = By.name("q");
    By btnBuscarLocator = By.name("btnK");

    //Metodos de la pagina
    public void ingresarAHomePage(){
        navigateTo(BASE_URL_AUT);
    }

    public void buscarEnBarraGoogle(String texto){
        write(texto, barraBusquedaLocator);
        click(btnBuscarLocator);
    }

}
