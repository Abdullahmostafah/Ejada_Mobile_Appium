package Utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.nio.file.Paths;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private static final String REPORT_FOLDER = ConfigReaderWriter.getPropKey("report.folder");
    private static final String REPORT_NAME = ConfigReaderWriter.getPropKey("report.name");

    @Override
    public void onStart(ITestContext context) {
        // Build the report path under /target/reports/ExtentReport.html
        String reportPath = Paths.get(System.getProperty("user.dir"), REPORT_FOLDER, REPORT_NAME + ".html").toString();

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("✅ Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}