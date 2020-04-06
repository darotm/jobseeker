package selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import reports.TestReport;

import java.io.IOException;

public class Rules extends TestReport {
    private static final Logger logger = LogManager.getLogger(Core.class);

    @Rule
    public TestWatcher failedTest = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            ScreenshotDriver.takeScreenshot(description.getClass().getSimpleName(), description.getMethodName(), e);
            try {
                failTest(e);
                logger.info("test failed");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    };

    @Rule
    public TestWatcher succeededTest = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
            passTest(description);
            logger.info("test succeeded");
        }
    };

}
