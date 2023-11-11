package co.edu.udea.questions;

import co.edu.udea.userinterfaces.AmazonPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Validation implements Question<Boolean> {

    private static final String EXPECTED_NUMBER = "1";

    @Override
    public Boolean answeredBy(Actor actor) {
        String validationText = actor.asksFor(Text.of(AmazonPage.CART_ITEMS_NUMBER).asString());
        System.out.println(String.format("Result: %s", validationText));
        return validationText.equals(EXPECTED_NUMBER);
    }

    public static Validation theCartCount() {
        return new Validation();
    }
}
