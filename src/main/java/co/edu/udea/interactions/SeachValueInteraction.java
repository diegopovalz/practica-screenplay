package co.edu.udea.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.edu.udea.userinterfaces.AmazonPage.SEARCH_INPUT;

public class SeachValueInteraction  implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("VIZIO TV").into(SEARCH_INPUT).thenHit(Keys.RETURN)
        );
    }

    public static SeachValueInteraction enterValue() {
        return Tasks.instrumented(SeachValueInteraction.class);
    }
}
