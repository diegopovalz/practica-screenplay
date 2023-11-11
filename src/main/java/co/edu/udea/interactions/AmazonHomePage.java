package co.edu.udea.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static co.edu.udea.userinterfaces.AmazonPage.*;

public class AmazonHomePage implements Interaction {

    private WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("VIZIO TV").into(SEARCH_INPUT).thenHit(Keys.RETURN),
                Click.on(ITEM_LIST),
                Click.on(ADD_TO_CART_BUTTON)
        );
    }

    public static AmazonHomePage go(WebDriver driver) {
        return Tasks.instrumented(AmazonHomePage.class, driver);
    }
}
