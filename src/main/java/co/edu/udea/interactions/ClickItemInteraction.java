package co.edu.udea.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.userinterfaces.AmazonPage.ITEM_LIST;

public class ClickItemInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ITEM_LIST)
        );
    }

    public static ClickItemInteraction clickItem() {
        return Tasks.instrumented(ClickItemInteraction.class);
    }
}
