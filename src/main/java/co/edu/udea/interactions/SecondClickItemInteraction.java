package co.edu.udea.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.userinterfaces.AmazonPage.ITEM_LIST;
import static co.edu.udea.userinterfaces.AmazonPage.SECOND_ITEM_LIEST;

public class SecondClickItemInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SECOND_ITEM_LIEST)
        );
    }

    public static SecondClickItemInteraction clickItem() {
        return Tasks.instrumented(SecondClickItemInteraction.class);
    }
}
