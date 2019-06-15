package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaggagePage extends PageObject {

    final static String FREE_BAG = "div[class^='priority-boarding-view__journey-list'] div priority-cabin-bag-card:nth-child(1)";
    final static String BAG_CONTINUE = "//button/span[text() = 'Continue']";

    public BaggagePage(WebDriver driver){

        super(driver);
    }

    @FindBy(css = FREE_BAG)
    private WebElement freeBagOption;

    @FindBy(xpath = BAG_CONTINUE)
    private WebElement bagContinueButton;

    public void chooseFreeBagOption(){
       waitUntilClickable(freeBagOption);
        this.freeBagOption.click();
    }

    public void bagContinueButton(){
        waitUntilVisible(bagContinueButton);
        waitUntilClickable(bagContinueButton);
        this.bagContinueButton.click();
    }
}
