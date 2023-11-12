package co.edu.udea.practica.stepdefinitions;

import co.edu.udea.interactions.SecondClickItemInteraction;
import co.edu.udea.tasks.OpenThe;
import co.edu.udea.userinterfaces.AmazonPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.edu.udea.interactions.SeachValueInteraction.enterValue;
import static co.edu.udea.interactions.SecondClickItemInteraction.clickItem;
import static co.edu.udea.questions.ButtonNotDisplayValidation.buttonNotDisplayed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ItemNotInStockStepDefinitions {
    @Managed(driver = "chrome")
    public WebDriver driver;

    private Actor client = Actor.named("Cliente2");

    @Before
    public void setup() {
        driver.manage().window().maximize();
        client.can(BrowseTheWeb.with(driver));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Given("que estoy en la pagina inicial")
    public void queEstoyEnLaPaginaInicial() {
        client.can(BrowseTheWeb.with(driver));
        client.attemptsTo(OpenThe.Browser(new AmazonPage()));
    }

    @When("busque un item que no esta en stock")
    public void busqueUnItemQueNoEstaEnStock() {
        client.attemptsTo(enterValue("GIGABYTE GeForce RTX 3070 Gaming OC 8G (REV2.0) Graphics Card, 3X WINDFORCE Fans, LHR, 8GB 256-bit GDDR6, GV-N3070GAMING OC-8GD Video Card"));
    }

    @And("entre al primer item de la lista")
    public void entreAlPrimerItemDeLaLista() {
        client.attemptsTo(clickItem());
    }

    @Then("no debe aparecer el boton de agregar al carrito")
    public void noDebeAparecerElBotonDeAgregarAlCarrito() {
        client.should(seeThat(buttonNotDisplayed(driver), equalTo(true)));
    }
}
