package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageObject {

    final static String CHECK_OUT = "div.trips-basket.trips-cnt button";
    final static String TITLE = "select[id^='title']";
    final static String FIRST_NAME = "input[id^='firstName']";
    final static String LAST_NAME = "input[id^='lastName']";
    final static String CARD_NUMBER = "input[name='cardNumber']";
    final static String CARD_MONTH = "select[name='expiryMonth']";
    final static String CARD_YEAR = "select[name='expiryYear']";
    final static String CARD_SECURITY_CODE = "input[name='securityCode']";
    final static String CARDHOLDERS_NAME = "input[name='cardHolderName']";
    final static String BILLING_ADDRESS1 = "billingAddressAddressLine1";
    final static String CITY = "billingAddressCity";
    final static String ZIP_CODE = "billingAddressPostcode";
    final static String COUNTRY = "select#billingAddressCountry";
    final static String ACCEPT_TERMS = "div.terms label span core-icon";
    final static String PAY_NOW = "div.cta button";
    final static String PAYMENT_ERROR = "div.info-title";

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = CHECK_OUT)
    private WebElement openCheckOut;

    @FindBy(css = TITLE)
    private WebElement title;

    @FindBy(css = FIRST_NAME)
    private WebElement firstName;

    @FindBy(css = LAST_NAME)
    private WebElement lastName;

    @FindBy(css = CARD_NUMBER)
    private WebElement cardNumber;

    @FindBy(css = CARD_MONTH)
    private WebElement cardMonth;

    @FindBy(css = CARD_YEAR)
    private WebElement cardYear;

    @FindBy(css = CARD_SECURITY_CODE)
    private WebElement cardSecurityCode;

    @FindBy(css = CARDHOLDERS_NAME)
    private WebElement cardholdersName;

    @FindBy(id = BILLING_ADDRESS1)
    private WebElement billingAddress1;

    @FindBy(id = CITY)
    private WebElement city;

    @FindBy(id = ZIP_CODE)
    private WebElement zipCode;

    @FindBy(css = COUNTRY)
    private WebElement country;

    @FindBy(css = ACCEPT_TERMS)
    private WebElement acceptTerms;

    @FindBy(css = PAY_NOW)
    private WebElement payNow;

    @FindBy(css = PAYMENT_ERROR)
    private WebElement paymentError;

    public void openCheckOut() throws InterruptedException{
        Thread.sleep(200);
        this.openCheckOut.click();
    }

    public void selectTitle(String value){
        waitUntilVisible(title);
        Select title = new Select(this.title);
        title.selectByValue(value);
    }

    public void insertFirstName(String value){
        this.firstName.sendKeys(value);
    }

    public void insertLastName(String value){
        this.lastName.sendKeys(value);
    }

    public void insertCardNumber(String value){
        this.cardNumber.sendKeys(value);
    }

    public void selectCardMonth(String value){
        Select title = new Select(this.cardMonth);
        title.selectByValue(value);
    }

    public void selectCardYear(String value){
        Select title = new Select(this.cardYear);
        title.selectByValue(value);
    }

    public void insertCardSecurityCode(String value){
        this.cardSecurityCode.sendKeys(value);
    }

    public void insertCardholdersName(String value){
        this.cardholdersName.sendKeys(value);
    }

    public void insertBillingAddress1(String value){
        this.billingAddress1.sendKeys(value);
    }

    public void insertCity(String value){
        this.city.sendKeys(value);
    }

    public void insertZipCode(String value){
        this.zipCode.sendKeys(value);
    }

    public void selectCountry(String value){
        Select title = new Select(this.country);
        title.selectByVisibleText(value);
    }

    public void clickAcceptTerms(){
        waitUntilClickable(acceptTerms);
        this.acceptTerms.click();
    }

    public void clickPayNow(){
        waitUntilClickable(payNow);
        this.payNow.click();
    }

    public String paymentError(){
        waitUntilClickable(paymentError);
        return this.paymentError.getText();
    }
}
