import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport {

    private static ExtentSparkReporter htmlReporter;
    private static ExtentReports reports;
    private static ExtentTest test;

    public static void initialiseExtent(){
        reports = new ExtentReports();
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "extentReport.html");
        reports.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        test = reports.createTest(testName);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReport() {
        reports.flush();
    }
}
