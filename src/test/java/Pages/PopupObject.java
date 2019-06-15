package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupObject extends PageObject {

    final static String COOKIE_POPUP = ".cookie-popup__close";

    public PopupObject(WebDriver driver){
        super(driver);
    }

    @FindBy(css = COOKIE_POPUP)
    private WebElement closeCookiePopup;

    public void closeCookiePopup(){
        waitUntilClickable(closeCookiePopup);
        this.closeCookiePopup.click();
    }
}
