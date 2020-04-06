package pagefactory.linkedin.actions;


import pagefactory.linkedin.homepage.HomePage;
import selenium.Core;

public class Actions extends Core {
    public static HomePage mainPage() {
        return new HomePage();
    }

}
