package pagefactory.linkedin.homepage;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import org.openqa.selenium.WebElement;
import pagefactory.linkedin.dashboard.Dashboard;

public class LoginPage {
    private final String user = System.getProperty("user");
    private final String password = System.getProperty("password");

    public LoginPage() {
        Metalloid.initializePage(this);
    }

    @FindBy(css = "input[type='text'")
    private WebElement emailTextField;

    @FindBy(css = "input[type='password'")
    private WebElement passwordTextField;

    @FindBy(css = "button[type='submit']")
    private WebElement signInButton;

    public Dashboard loginAsUser() {
        return loginIntoSystem(user, password);
    }

    public Dashboard loginIntoSystem(String email, String password) {
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        signInButton.click();
        return new Dashboard();
    }
}
