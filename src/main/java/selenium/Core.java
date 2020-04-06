package selenium;

import com.github.metalloid.webdriver.WebDriverPool;
import metalloid.controls.CookieHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class Core extends Rules {
    private static Set<Cookie> allCookies;
    private static final Logger logger = LogManager.getLogger(Core.class);

    @Before
    public void openSession() {
        WebDriverPool.get();
        CookieHandler.restoreAllCookies(allCookies);
        logger.info("Open Selenium session");
    }

    @After
    public void closeSession() {
        allCookies = CookieHandler.getAllCookies();
        //WebDriverPool.closeSession(Thread.currentThread());
        logger.info("Close Selenium session");
        //logger.warn("WARN");
    }

    @BeforeClass
    public static void runReport() {
        openReport();
        logger.info("Open report");
    }

    @AfterClass
    public static void exitReport() {
        closeReport();
        logger.info("Close report");

    }

}
