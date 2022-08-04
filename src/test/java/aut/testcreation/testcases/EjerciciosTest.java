package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import groovy.transform.Undefined;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class EjerciciosTest extends SeleniumTestBase {

    WebDriver driver;

    By textAreaOrigenLocator = By.xpath("//div[@class='QFw9Te']/textarea");
    By textAreaRespuestaLocator = By.xpath("//span[@class='VIiyi']/span");
    By buttonInglesLocator = By.xpath("(//span[@class='VfPpkd-YVzG2b' and @jsname='ksKsZd'])[6]");

    By buttonIdiomasLocator = By.xpath("(//button[@jsname='zumM6d'])[1]");
    By buttonPortuguesLocator = By.xpath("(//div[@jsname='rPx1uf']/div[@data-language-code='pt'])[2]");

    //Calculadora

    By buscadorLocator = By.xpath("//input[@aria-label='Buscar']");
    By resultadoLocator = By.xpath("//span[@id='cwos']");

    @Test
    void calculadora(){
        //int res = calcular(20, 5, "-");
        Assertions.assertEquals(25, calcular(20, 5, "+"));
        Assertions.assertEquals(15, calcular(20, 5, "-"));
        Assertions.assertEquals(10, calcular(2, 5, "*"));
        Assertions.assertEquals(4, calcular(20, 5, "/"));
    }

    private int calcular(int num1, int num2, String operacion) {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.google.com/");
        int res = 0;

        WebElement buscador = driver.findElement(buscadorLocator);

        if(buscador.isDisplayed())
            buscador.sendKeys(num1 + operacion + num2 + Keys.ENTER);

        WebElement resultado = driver.findElement(resultadoLocator);

        if(resultado.isDisplayed())
            res = Integer.parseInt(resultado.getText());

        return res;
    }

    @Test
    void translateEnglish(){
        inicializacion();
        String respuesta;

        WebElement buttonIngles = driver.findElement(buttonInglesLocator);
        buttonIngles.click();

        respuesta = driver.findElement(textAreaRespuestaLocator).getText();

        Assertions.assertEquals("Hello", respuesta);
    }

    @Test
    void translatePortugues() throws InterruptedException {
        inicializacion();
        String respuesta = null;

        WebElement buttonIdiomas = driver.findElement(buttonIdiomasLocator);
        buttonIdiomas.click();
        Thread.sleep(1000);
        WebElement buttonPortugues = driver.findElement(buttonPortuguesLocator);
        if(buttonPortugues.isDisplayed()){
            buttonPortugues.click();
            Thread.sleep(1000);
            respuesta = driver.findElement(textAreaRespuestaLocator).getText();
            System.out.println("Res: " + respuesta);
        }


        Assertions.assertEquals("Olá", respuesta);
    }

    private void inicializacion() {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://translate.google.com/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement textAreaOrigen = driver.findElement(textAreaOrigenLocator);
        textAreaOrigen.sendKeys("Hola");
    }
}