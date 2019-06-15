package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    final static String LOGIN_MENU = "#myryanair-auth-login a";
    final static String EMAIL_ADDRESS = "emailAddress";
    final static String PASSWORD = "password-input input[id^='password']";
    final static String LOGIN_BUTTON = "//span/translate[text()='Log in']";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = LOGIN_MENU)
    private WebElement logInMenu;

    @FindBy(name = EMAIL_ADDRESS)
    private WebElement emailAddressField;

    @FindBy(css = PASSWORD)
    private WebElement passwordField;

    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement logInButton;

    public void clickLogInMenu(){
        waitUntilClickable(logInMenu);
        this.logInMenu.click();
    }

    public void fillEmailAddressField(String value){
        waitUntilVisible(emailAddressField);
        this.emailAddressField.sendKeys(value);
    }

    public void fillPasswordField(String value){
        this.passwordField.sendKeys(value);
    }

    public void clickLogInButton(){
        waitUntilClickable(logInButton);
        this.logInButton.click();
    }
}
