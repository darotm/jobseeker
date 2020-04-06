package reports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public interface ReporterConfig {
    void setReporter();
    ExtentHtmlReporter getReporter();
}
