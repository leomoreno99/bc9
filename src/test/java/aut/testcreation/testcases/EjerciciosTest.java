package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class EjerciciosTest extends SeleniumTestBase {

    WebDriver driver;

    @Test
    @Description("Ejercicios de Test bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        driver = DriverFactory.getDriver();




        Assertions.assertTrue(true);
    }
}