package pagefactory.linkedin.homepage;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.WebDriverPool;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final String env = System.getProperty("environment");

    public HomePage(){
        Metalloid.initializePage(this);
    }

    public HomePage openUrl() {
        WebDriverPool.get().get(env);
        return this;
    }

    @FindBy(css = "a[class*='nav__button-secondary']")
    private WebElement signInButton;

    @FindBy(id = "recaptcha-anchor")
    private WebElement captcha;

    public LoginPage signIn() {
        signInButton.click();
        return new LoginPage();
    }

    public LoginPage captchaApprove() {
        captcha.click();
        return new LoginPage();
    }
}
