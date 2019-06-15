package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class HomePage extends PageObject {

    final static String ONE_WAY_OPTION = "input[value='one-way']";
    final static String DEPARTURE_AIRPORT_NAME = "input[aria-labelledby='label-airport-selector-from']";
    final static String DESTINATION_AIRPORT_NAME = "input[aria-labelledby='label-airport-selector-to']";
    final static String FLY_OUT_DAY = "input[aria-label='Fly out: - DD']";
    final static String FLY_OUT_MONTH = "input[aria-label='Fly out: - MM']";
    final static String FLY_OUT_YEAR = "input[aria-label='Fly out: - YYYY']";
    final static String LETS_GO_BUTTON = "//button/span[contains(text(), 'Let')]";

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ONE_WAY_OPTION)
    private WebElement oneWay;

    @FindBy(css = DEPARTURE_AIRPORT_NAME)
    private WebElement departureAirport;

    @FindBy(css = DESTINATION_AIRPORT_NAME)
    private WebElement destinationAirport;

    @FindBy(css = FLY_OUT_DAY)
    private WebElement flyOutDay;

    @FindBy(css = FLY_OUT_MONTH)
    private WebElement flyOutMonth;

    @FindBy(css = FLY_OUT_YEAR)
    private WebElement flyOutYear;

    @FindBy(xpath = LETS_GO_BUTTON)
    private WebElement letsGoButton;

    public void selectOneWayOption(){
        waitUntilVisible(this.destinationAirport);
        refreshPage();
        this.oneWay.click();
    }

    private void fillAirport(String value, WebElement airport){
        waitUntilVisible(airport);
        airport.clear();
        airport.sendKeys(value);
        airport.sendKeys(Keys.RETURN);
    }

    public void fillDestinationAirport(String value){
        fillAirport(value, this.destinationAirport);
    }

    public void fillDepartureAirport(String value){
        fillAirport(value, this.departureAirport);
    }

    private void fillDate(LocalDate date, WebElement day, WebElement month, WebElement year){
        waitUntilVisible(day);
        waitUntilClickable(day);
        waitUntilClickable(month);
        waitUntilClickable(year);
        day.sendKeys(Integer.toString(date.getDayOfMonth()));
        month.sendKeys(Integer.toString(date.getMonthValue()));
        year.sendKeys(Integer.toString(date.getYear()));
    }

    public void fillFlyOutDate(LocalDate date){
        fillDate(date, this.flyOutDay, this.flyOutMonth, this.flyOutYear);
    }

    public void clickLetsGoButton(){
        this.letsGoButton.click();
    }
}
