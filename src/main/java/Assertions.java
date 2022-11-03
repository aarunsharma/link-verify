import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

public class Assertions {

    public static void assertTrue(boolean condition, String passMessage, String failMessage) throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot)WebDriverUtil.getDriver();
        try {
            Assert.assertTrue(condition);
            ExtentReport.getTest().log(Status.PASS,passMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot.getScreenshotAs(OutputType.BASE64)).build());
        } catch (Exception e) {
            ExtentReport.getTest().log(Status.PASS,passMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot.getScreenshotAs(OutputType.BASE64)).build());
            throw new RuntimeException(e);
        }
    }
}
