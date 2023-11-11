package co.edu.udea.practica.stepdefinitions;

import co.edu.udea.questions.Validation;
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

import static co.edu.udea.interactions.AddToCartInteraction.addToCart;
import static co.edu.udea.interactions.ClickItemInteraction.clickItem;
import static co.edu.udea.interactions.SeachValueInteraction.enterValue;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddItemToCartStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver driver;

    private Actor client = Actor.named("Cliente");

    @Before
    public void setup() {
        driver.manage().window().maximize();
        client.can(BrowseTheWeb.with(driver));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Given("que estoy en la homepage de Amazon")
    public void queEstoyEnLaHomepageDeAmazon() {
        client.can(BrowseTheWeb.with(driver));
        client.attemptsTo(OpenThe.Browser(new AmazonPage()));
    }

    @When("busque un item en la barra de busqueda")
    public void busqueUnItemEnLaBarraDeBusqueda() {
        client.attemptsTo(enterValue());
    }

    @And("entre al primer item")
    public void entreAlPrimerItem() {
        client.attemptsTo(clickItem());
    }

    @And("de click al boton de Agregar al carrito")
    public void deClickAlBotonDeAgregarAlCarrito() {
        client.attemptsTo(addToCart());
    }

    @Then("el icono del carrito debe tener un 1")
    public void elIconoDelCarritoDebeTenerUn1() {
        client.should(seeThat(Validation.theCartCount(), equalTo(true)));
    }
}
