package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeatPage extends PageObject {

    final static String RANDOM_ALLOCATION_SEAT = "//button/span[text() = 'I choose random allocation']";

    public SeatPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = RANDOM_ALLOCATION_SEAT)
    private WebElement randomAllocationSeat;

    public void chooseRandomAllocationSeat(){
        waitUntilClickable(randomAllocationSeat);
        this.randomAllocationSeat.click();
    }
}
