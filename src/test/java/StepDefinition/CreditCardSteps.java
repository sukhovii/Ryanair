package StepDefinition;


import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CreditCardSteps extends BaseSteps{
    @Before
    public void initializeDriver(){
        initializeWebDriver();
    }

    @After
    public void closeDriver(){
        closeWebDriver();
    }

    @Given("^Open browser$")
    public void openBrowser() {
        openApplicationURL();
        PopupObject popup = new PopupObject(driver);
        popup.closeCookiePopup();
    }

    @When("^Login under test user with credentials \"([^\"]*)\" \"([^\"]*)\"$")
    public void loginUnderTestUser(String login, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogInMenu();
        loginPage.fillEmailAddressField(login);
        loginPage.fillPasswordField(password);
        loginPage.clickLogInButton();
    }

    @And("^Select flight from \"([^\"]*)\" to \"([^\"]*)\" in (\\d+) days from today$")
    public void selectFlight(String from, String to, int days){
        HomePage home = new HomePage(driver);
        home.selectOneWayOption();
        home.fillDepartureAirport(from);
        home.fillDestinationAirport(to);
        home.fillFlyOutDate(getDate(days));
        home.clickLetsGoButton();
    }

    @And("^Fill all needed flight information$")
    public void fillAllNeededFlightInformation(){
        PricePage price = new PricePage(driver);
        price.clickPriceFromButton();
        price.selectStandardFare();
        price.clickContinueButton();

        SeatPage seats = new SeatPage(driver);
        seats.chooseRandomAllocationSeat();

        BaggagePage baggage = new BaggagePage(driver);
        baggage.chooseFreeBagOption();
        baggage.bagContinueButton();
    }

    @And("^Fill passenger info with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void fiilPassengerInfo(String title, String name, String surname) throws InterruptedException{
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.openCheckOut();
        checkout.selectTitle("string:" + title);
        checkout.insertFirstName(name);
        checkout.insertLastName(surname);
    }

    @And("^Add card data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void addCardData(String number, String month, String year, String cvv, String cardholder) {
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.insertCardNumber(number);
        checkout.selectCardMonth("number:" + month);
        checkout.selectCardYear("number:" + year);
        checkout.insertCardSecurityCode(cvv);
        checkout.insertCardholdersName(cardholder);
    }

    @And("^Add billing address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void addBillingAddress(String country, String city, String address, String code){
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.insertBillingAddress1(address);
        checkout.insertCity(city);
        checkout.insertZipCode(code);
        checkout.selectCountry(country);
        checkout.clickAcceptTerms();
        checkout.clickPayNow();
    }

    @Then("^Error message$")
    public void errorMessage(){
        CheckoutPage checkout = new CheckoutPage(driver);
        Assert.assertEquals("Oh. There was a problem", checkout.paymentError());
    }

}
