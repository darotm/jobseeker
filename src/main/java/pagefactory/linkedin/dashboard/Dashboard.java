package pagefactory.linkedin.dashboard;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import org.openqa.selenium.WebElement;

public class Dashboard {
    public Dashboard(){
        Metalloid.initializePage(this);
    }

    @FindBy(css ="button[class='secondary-action']")
    private WebElement addPhoneNumberSkip;

    @FindBy(css = "input[placeholder='Search']")
    private WebElement searchFiled;

    @FindBy(css = "button[type='button']")
    private WebElement submit;

    @FindBy(id = "jobs-tab-icon")
    private WebElement jobs;

    public Dashboard addPhoneNumberSkip() {
       addPhoneNumberSkip.click();
       return this;
    }

    public Dashboard search(String statement) {
        searchFiled.sendKeys(statement);
        return this;
    }

    public Dashboard submit() {
        submit.click();
        return this;
    }

    public Jobs jobs() {
        jobs.click();
        return new Jobs();
    }

}
