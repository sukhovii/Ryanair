package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricePage extends PageObject {

    final static String PRICE_FROM = "div.flight-header__min-price.hide-mobile flights-table-price div.flights-table-price";
    final static String STANDARD_FARE = "div.flights-table-fares div.flights-table-fares__fare.fare-select.standard";
    final static String CONTINUE_BUTTON = "continue";

    public PricePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = PRICE_FROM)
    private WebElement priceFromButton;

    @FindBy(css = STANDARD_FARE)
    private WebElement standardFare;

    @FindBy(id = CONTINUE_BUTTON)
    private WebElement continueButton;

    public void clickPriceFromButton(){
        waitUntilVisible(priceFromButton);
        this.priceFromButton.click();
    }

    public void selectFare(WebElement fare){
        waitUntilVisible(fare);
        fare.click();
    }

    public void selectStandardFare(){
        selectFare(this.standardFare);
    }

    public void clickContinueButton(){
        waitUntilClickable(continueButton);
        this.continueButton.click();
    }
}
