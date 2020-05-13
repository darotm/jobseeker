package pagefactory.linkedin.dashboard;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.JavaScript;
import com.github.metalloid.webdriver.utils.Wait;
import metalloid.controls.KeyboardKeys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tester {
    @Inject
    private Wait wait;

    @Inject
    private JavaScript javaScript;

    public Tester() {
        Metalloid.initializePage(this);
    }

    @FindBy(css = "form[aria-label='Filter results by: Date Posted']")
    private WebElement datePosted;

    @FindBy(css = "button[data-control-name='filter_pill_apply']")
    private WebElement apply;

    @FindBy(css = "label[for='f_TPR-r86400']")
    private WebElement twentyFourHours;

    @FindBy(css = "label[for='f_TPR-r604800']")
    private WebElement pastWeek;

    @FindBy(className = "compactfooter-help")
    private WebElement helpCenter;

    @FindBy(className = "jobs-search-results jobs-search-results--is-two-pane")
    private WebElement results;

    private void datePosted() {
        wait.until(ExpectedConditions.visibilityOf(datePosted));
        datePosted.click();
    }

    public Tester datePostedTwentyFourHours() {
        datePosted();
        twentyFourHours.click();
        return this;
    }

    public Tester datePostedPastWeek() {
        datePosted();
        pastWeek.click();
        return this;
    }

    public Past24Hours datePostedApply() {
        apply.click();
        wait.sleep(6);
        KeyboardKeys.arrowDownAndUp(35, 35);
        return new Past24Hours();
    }
}
