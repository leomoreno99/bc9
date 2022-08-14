package desafio.grupo3.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservaPageTrenes extends SeleniumWrapper
{
    public ReservaPageTrenes(WebDriver driver)
    {
        super(driver);
    }

    //Locator
    By nombreReservaLocator = By.name("name");
    By nombreErrorReservaLocator = By.xpath("(//label [@for='name'])[2]");
    By apellidoReservaLocator = By.name("surname");
    By apellidoErrorReservaLocator = By.xpath("(//label [@for='surname'])[2]");
    By emailReservaLocator = By.id("contact-email");
    By emailErrorReservaLocator = By.xpath("(//label [@for='email'])[2]");
    By telefonoReservaLocator = By.name("phone");
    By telefonoErrorReservaLocator = By.xpath("(//label [@for='phone'])[2]");

    By srViajaLocator = By.id("radio-groups.1.travellers.1.title-MALE-label");
    By sraViajaLocator = By.id("radio-groups.1.travellers.1.title-FEMALE-label");
    By srErrorViajaLocator = By.xpath("(//label [@for='groups.1.travellers.1.title'])[2]");
    By nombreViajaLocator = By.name("groups.1.travellers.1.name");
    By nombreErrorViajaLocator = By.xpath("(//label [@for='groups.1.travellers.1.name'])[2]");
    By apellidoViajaLocator = By.name("groups.1.travellers.1.surname");
    By apellidoErrorViajaLocator = By.xpath("(//label [@for='groups.1.travellers.1.surname'])[2]");
    By diaFechaNacViajaLocator = By.name("groups.1.travellers.1.dateOfBirth");
    By mesFechaNacViajaLocator = By.xpath("//select [@aria-label='Selecciona el mes']");
    By anoFechaNacViajaLocator = By.name("groups.1.travellers.1.dateOfBirth");
    By errorFechaNacViajaLocator = By.xpath("//div [@data-test='date-input-error']");


}
