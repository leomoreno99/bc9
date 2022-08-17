package desafio.grupo3.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    By diaFechaNacViajaLocator = By.xpath("(//input [@name='groups.1.travellers.1.dateOfBirth'])[1]");
    By mesFechaNacViajaLocator = By.xpath("//select [@aria-label='Selecciona el mes']");
    By anoFechaNacViajaLocator = By.xpath("(//input [@name='groups.1.travellers.1.dateOfBirth'])[2]");
    By errorFechaNacViajaLocator = By.xpath("//div [@data-test='date-input-error']");


    By btnSiguienteLocator = By.xpath("//button [@data-test='lead-generation-submit-btn']");

    //Metodos

    public void ingresarNombre(String nombre)
    {
        write(nombre,nombreReservaLocator);
    }
    public void ingresarApellido(String apellido)
    {
        write(apellido,apellidoReservaLocator);
    }
    public void ingresarEmail(String email)
    {
        write(email,emailReservaLocator);
    }
    public void ingresarTelefono(String telefono)
    {
        write(telefono,telefonoReservaLocator);
    }
    public void seleccionSr()
    {
        click(srViajaLocator);
    }
    public void seleccionSra()
    {
        click(sraViajaLocator);
    }
    public void ingresarNombreViaje(String nombre)
    {
        write(nombre,nombreViajaLocator);
    }
    public void ingresarApellidoViaje(String apellido)
    {
        write(apellido,apellidoViajaLocator);
    }
    public void ingresarFechaNac(String dia,String mes, String ano)
    {
        write(dia,diaFechaNacViajaLocator);
        Select mesSelect = new Select(findElement(mesFechaNacViajaLocator));
        mesSelect.selectByValue(mes);
        write(ano,anoFechaNacViajaLocator);
    }
    public String errorNombreReserva()
    {
        return getText(nombreErrorReservaLocator);
    }
    public String errorApellidoReserva()
    {
        return getText(apellidoErrorReservaLocator);
    }
    public String errorEmailReserva()
    {
        return getText(emailErrorReservaLocator);
    }
    public String errorTelefonoReserva()
    {
        return getText(telefonoErrorReservaLocator);
    }
    public String errorSroSraViaja()
    {
        return getText(srErrorViajaLocator);
    }
    public String errorNombreViaja()
    {
        return getText(nombreErrorViajaLocator);
    }
    public String errorApellidoViaja()
    {
        return getText(apellidoErrorViajaLocator);
    }
    public String errorFechaNacViaja()
    {
        return getText(errorFechaNacViajaLocator);
    }
    public void siguiente()
    {
        click(btnSiguienteLocator);
    }

    public String ValidacionErrorReserva()
    {
        siguiente();
        return errorNombreReserva()+" , "+errorApellidoReserva()+" , "+errorEmailReserva()+" y "+errorTelefonoReserva();
    }
    public void ValidacionCamposReserva(String nombreReserva,String apellidoReserva, String emailReserva, String telefonoReserva)
    {
        ingresarNombre(nombreReserva);
        ingresarApellido(apellidoReserva);
        ingresarEmail(emailReserva);
        ingresarTelefono(telefonoReserva);
    }
    public String ValidacionErrorViaja()
    {
        siguiente();
        return errorSroSraViaja()+" , "+errorNombreViaja()+" , "+errorApellidoViaja()+" , "+errorFechaNacViaja();
    }
    public void ValidacionCamposViaja(String nombreViaja,String apellidoViaja, String diaViaja, String mesViaja, String anoViaja)
    {
        seleccionSra();
        seleccionSr();
        ingresarNombreViaje(nombreViaja);
        ingresarApellidoViaje(apellidoViaja);
        ingresarFechaNac(diaViaja,mesViaja,anoViaja);
    }

}
