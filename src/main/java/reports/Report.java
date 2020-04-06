package reports;

import com.aventstack.extentreports.ExtentReports;

public interface Report {
    void setReport(ReporterConfig config);
    ExtentReports getReport();
}


