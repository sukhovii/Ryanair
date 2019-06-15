package StepDefinition;

import Driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class BaseSteps {
    protected static WebDriver driver;

    protected LocalDate getDate(int days){
        ZoneId z = ZoneId.of("Europe/Warsaw");
        Period p = Period.ofDays(days);
        LocalDate today = LocalDate.now(z);
        LocalDate date = today.plus(p);
        return date;
    }

    public void initializeWebDriver() {

        driver = DriverInitializer.getDriver();
    }

    public void openApplicationURL(){
        driver.get(DriverInitializer.getProperty("home.url"));
    }

    public void closeWebDriver(){
        driver.close();
    }
}
