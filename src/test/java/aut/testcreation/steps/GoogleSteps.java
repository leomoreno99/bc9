package aut.testcreation.steps;
import aut.testcreation.pages.GoogleHomePage;
import aut.testplan.sprint.GoogleTestRunner;
import framework.engine.selenium.DriverFactory;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.atomic.AtomicReference;


public class GoogleSteps extends GoogleTestRunner implements En{

    GoogleHomePage googleHomePage;

    public GoogleSteps(){



        Before(2, GoogleTestRunner::setUp); //cada vez que ejecute un scenario

        After(GoogleTestRunner::tearDown);

        Given("que estoy en el Home de Google", () -> {
            googleHomePage = new GoogleHomePage(driver);
            googleHomePage.navegarAlHome();
            Assertions.assertEquals("Google", googleHomePage.getUrlTitle());
        });

        When("busco la palabra {string} en el navegador", (String string) -> {
            googleHomePage.write(string, By.name("q"));
            Assertions.assertEquals("Tsoft", driver.findElement(By.name("q")).getText());
        });

        When("presiono el boton buscar", () -> {
            googleHomePage.click();
        });

        Then("me lleva a la pagina de resultados", () -> {
        });

        Given("today is Sunday", () -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });

        When("I ask whether it's Friday yet", () -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });

        Then("I should be told {string}", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });
    }
}
