package tests;

import categories.Dev;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pagefactory.Base;

public class HomePageTest extends Base {
    //@Test
    @Category(Dev.class)
    public void LinkedLogin_01() {
        createTest("LinkedLogin_01", "Home Page - logged successfully");
        Base
                .mainPage()
                .openUrl()
                .signIn()
                .loginAsUser()
                .jobs()
                .selectAlert("tester")
                .datePostedTwentyFourHours()
                .datePostedApply()
                .results("");
       // assertEquals(message, "Email and Password do not match!");
    }

    @Test
    @Category(Dev.class)
    public void LinkedLogin_02() {
        createTest("Search tester opportunities", "Location in Warsaw");
        Base.mainPage().openUrl().search("tester").location("Warszawa").submit();
    }

}
