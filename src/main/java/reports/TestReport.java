package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.runner.Description;
import selenium.ScreenshotDriver;

import java.io.IOException;

public class TestReport {
    private static ExtentReports extent;
    private ExtentTest test;
    private ExtentTest scenario;

    public void createTest(String caseName, String description) {
        test = extent.createTest(caseName, description);
    }

    public void createScenario(String stepName) {
        test.createNode(stepName);
    }

    public void failTest(Throwable exception) throws IOException {
        if(exception != null) {
            test.addScreenCaptureFromPath(ScreenshotDriver.getScreenshot(), "FAIL");
            test.fail(exception);
            test.assignCategory("FAILED");
            test.assignAuthor("Dariusz Tulimowski");
        }
    }

    public void passTest(Description description) {
       // test.info(description.getMethodName());
        test.pass(description.toString());
        test.assignCategory("PASSED");
        test.assignAuthor("Daro");
    }

    public static void openReport() {
        ReportFactory reportFactory = new ReportFactory();
        Standard standard = new Standard();
        reportFactory.setReport(standard);
        extent = reportFactory.getReport();
    }

    public static  void closeReport() {
        System.out.println("Report saved on /openbeds/ReportFactory.html" );
        extent.flush();
    }
}
