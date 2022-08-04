package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ManejoWebElements {

    static WebDriver driver;

    By dropdownLocator = By.id("dropdown");
    By check1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By check2 = By.xpath("//form[@id='checkboxes']/input[2]");

    By btnEnabledLocator = By.xpath("//ul[@id='menu']/li[2]/a");
    By btnDownloadLocator = By.xpath("//li[@id='ui-id-4']/a");
    By btnPDFLocator = By.xpath("//li[@id='ui-id-5']/a");
    By iframeLocator = By.id("mce_0_ifr");
    By iframeText = By.id("tinymce");

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Espera implicita -> Espera una cantidad de tiempo antes de enviar el timeOut Exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    //dropdown
    @Test
    void dropDown(){
        System.out.println("Test Dropdown");
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        //Crear como webElement
        WebElement dropdown = driver.findElement(dropdownLocator);

        //Como es un select, hay una libreria auxiliar
        Select select = new Select(dropdown);

        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    void checkbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //checkbox
        WebElement checkbox1 = driver.findElement(check1);
        WebElement checkbox2 = driver.findElement(check2);

        /*Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofMillis(5000))
                                    .pollingEvery(Duration.ofMillis(100))
                                    .ignoring(NoSuchElementException.class);*/

       // fluentWait.until(ExpectedConditions.elementToBeSelected(checkbox1));

        if(!checkbox1.isSelected())
            checkbox1.click();

        if(checkbox2.isSelected())
            checkbox2.click();
    }

    @Test
    void menuDinamico (){
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu#");

        WebElement btnEnabled = driver.findElement(btnEnabledLocator);
        WebElement btnDownload = driver.findElement(btnDownloadLocator);
        WebElement btnPDF = driver.findElement(btnPDFLocator);

        //Espera explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));



        if(wait.until(ExpectedConditions.elementToBeSelected(btnDownload)))
            btnDownload.click();

        /*if(btnDownload.isEnabled())
            btnDownload.click();*/

        if(btnEnabled.isDisplayed())
            btnEnabled.click();
            btnDownload.click();
            btnPDF.click();

    }

    @Test
    void iframes(){
        driver.navigate().to("https://the-internet.herokuapp.com/tinymce");

        //Traernos todos los iframes de la pagina
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement iframeTextElement = driver.findElement(iframeText);
        iframeTextElement.clear();
        iframeTextElement.sendKeys("Hola");

    }

    @Test
    void webTables(){
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //Traer los elementos que contenga esta tabla
        List<WebElement> webTable = driver.findElements(By.id("table1"));

        //Cuantas columnas tiene el WebTable?
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        for(WebElement th : columnas){
            String text = th.getText();
            if(text.contains("Due")){
                th.click();
                th.click();
                break;
            }
        }

        //Obtener filas del webtable
        List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        List<WebElement> mayDeudor = filas.get(0).findElements(By.tagName("td"));
        String nombre = mayDeudor.get(1).getText();
        String deuda = mayDeudor.get(3).getText();
        System.out.println("La persona con la deuda mas alta es " + nombre + " con una deuda de " + deuda);

    }

    @AfterEach
    void close(){
        driver.quit();
    }


}
