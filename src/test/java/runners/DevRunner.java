package runners;

import categories.Dev;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.HomePageTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(Dev.class)
@Suite.SuiteClasses({ HomePageTest.class})
public class DevRunner {

}
