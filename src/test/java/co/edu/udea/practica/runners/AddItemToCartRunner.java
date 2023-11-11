package co.edu.udea.practica.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/add_item_to_cart.feature",
        glue = "co.edu.udea.practica.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AddItemToCartRunner {
}
