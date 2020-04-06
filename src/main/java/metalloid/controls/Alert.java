package metalloid.controls;

import com.github.metalloid.webdriver.WebDriverPool;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(WebDriverPool.get(), 3);
        org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(WebDriverPool.get(), 5);
        org.openqa.selenium.Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message =  alert.getText();
        System.out.println("\n\nALERT " + message + "\n\n");

        return message;
    }
}
