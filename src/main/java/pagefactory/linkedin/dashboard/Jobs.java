package pagefactory.linkedin.dashboard;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import org.openqa.selenium.WebElement;

public class Jobs {
    public Jobs(){
        Metalloid.initializePage(this);
    }

    @FindBy(id = "jobs-search-box-keyword-id-ember7343")
    private WebElement searchFiled;

    @FindBy(id = "jobs-search-box-location-id-ember7343")
    private WebElement location;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    public Jobs search(String statement) {
        searchFiled.click();
        return this;
    }

    public Jobs location() {
        location.click();
        return this;
    }

    public Jobs submit() {
        submit.click();
        return this;
    }

}
