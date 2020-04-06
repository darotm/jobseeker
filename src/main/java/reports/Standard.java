package reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Standard implements ReporterConfig {
    private ExtentHtmlReporter extentHtmlReporter;
    private final String reportPath = "ReportFactory.html";

    public Standard() {
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
    }

    @Override
    public void setReporter() {
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setLevel(Status.INFO);
        extentHtmlReporter.config().setReportName("SELENIUM TESTS");
        extentHtmlReporter.config().enableTimeline(true);
    }

    @Override
    public ExtentHtmlReporter getReporter() {
        return extentHtmlReporter;
    }
}
