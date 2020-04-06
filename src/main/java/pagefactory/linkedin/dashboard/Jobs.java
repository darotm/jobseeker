package pagefactory.linkedin.dashboard;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import org.openqa.selenium.WebElement;

public class Jobs {
    public Jobs(){
        Metalloid.initializePage(this);
    }

    @FindBy(css = "input[aria-label='Search by title, skill, or company']")
    private WebElement search;

    @FindBy(css = "input[aria-label='City, state, or zip code']")
    private WebElement location;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    public Jobs search(String statement) {
        search.sendKeys(statement);
        return this;
    }

    public Jobs location(String city) {
        location.sendKeys(city);
        return this;
    }

    public Jobs submit() {
        submit.click();
        return this;
    }

}
