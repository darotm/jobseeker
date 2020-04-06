package runners;

import categories.HomePageCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.HomePageTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(HomePageCategory.class)
@Suite.SuiteClasses({ HomePageTest.class })
public class HomePageRunner {

}
