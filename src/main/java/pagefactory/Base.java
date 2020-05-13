package pagefactory;


import pagefactory.linkedin.homepage.HomePage;
import selenium.Core;

public class Base extends Core {
    public static HomePage mainPage() {
        return new HomePage();
    }

}
