package ExtentReports1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
    public static void main(String[] args) {
        // Report path
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

        // Attach reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Create a test
        ExtentTest test1 = extent.createTest("Login Test");
        test1.pass("Login successful");

        ExtentTest test2 = extent.createTest("Checkout Test");
        test2.fail("Checkout failed due to missing item");

        // Save the report
        extent.flush();
    }
}
