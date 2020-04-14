package pagefactory.linkedin.dashboard;

import com.github.metalloid.core.Metalloid;
import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.JavaScript;
import com.github.metalloid.webdriver.utils.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    @FindBy(className = "search-s-facet-value__name t-14 t-black--light t-normal")
    private List<WebElement> results;

    @FindBy(css = "button[data-control-name='filter_pill_apply']")
    private WebElement apply;

    @FindBy(css = "label[for='f_TPR-r86400']")
    private WebElement twentyFourHours;

    @FindBy(css = "label[for='f_TPR-r604800']")
    private WebElement pastWeek;

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
        wait.sleep(5);
        javaScript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return new Past24Hours();
    }
}
