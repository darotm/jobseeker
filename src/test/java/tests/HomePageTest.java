package tests;

import categories.Dev;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pagefactory.linkedin.actions.Actions;

public class HomePageTest extends Actions {
    //@Test
    @Category(Dev.class)
    public void LinkedLogin_01() {
        createTest("LinkedLogin_01", "Home Page - logged successfully");
        Actions.mainPage().openUrl().signIn().loginAsUser();
       // assertEquals(message, "Email and Password do not match!");
    }

    @Test
    @Category(Dev.class)
    public void LinkedLogin_02() {
        createTest("LinkedLogin_02", "Home Page - logged successfully");
        Actions.mainPage().openUrl().signIn().loginAsUser().jobs().search("tester").location("Warszawa").submit();
        // assertEquals(message, "Email and Password do not match!");
    }

}
