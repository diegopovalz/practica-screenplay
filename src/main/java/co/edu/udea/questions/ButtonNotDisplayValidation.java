package co.edu.udea.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ButtonNotDisplayValidation implements Question<Boolean> {

    private WebDriver driver;

    public ButtonNotDisplayValidation(WebDriver driver) {
        this.driver = driver;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElement> addToCartButton = driver.findElements(By.xpath("//*[@id='add-to-cart-button']"));
        return addToCartButton.isEmpty() || !addToCartButton.get(0).isDisplayed();
    }

    public static ButtonNotDisplayValidation buttonNotDisplayed(WebDriver driver) {
        return new ButtonNotDisplayValidation(driver);
    }
}
