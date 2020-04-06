package reports;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;

public class ReportFactory implements Report{
    private ExtentReports extent;

    public ReportFactory(){
        extent = new ExtentReports();
    }

    @Override
    public void setReport(ReporterConfig config) {
        config.setReporter();
        extent.attachReporter(config.getReporter());
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.setSystemInfo("Linux", "Chrome");
        extent.setSystemInfo("INTEL CORE i5 ", "8GB RAM");
    }

    @Override
    public ExtentReports getReport() {
        return extent;
    }
}
