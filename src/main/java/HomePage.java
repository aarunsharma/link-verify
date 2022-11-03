import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyHeaderLinks() throws Exception {
        By headerIdentifier = By.xpath("//ul[@id='HeaderAreaV1TopNavigation']/li/a");
        List<WebElement> headers = driver.findElements(headerIdentifier);
        for (int i = 0; i < headers.size(); i++) {
            verifyPage(driver.findElements(headerIdentifier).get(i));
            driver.navigate().back();
        }

    }

    public void verifyFooterLinks() throws Exception {
        By footerIdentifier = By.xpath("//nav[@id='FooterV1Links']/ul/li/a");
        List<WebElement> footers = driver.findElements(footerIdentifier);
        for (int i = 0; i < footers.size(); i++) {
            verifyPage(driver.findElements(footerIdentifier).get(i));
        }

    }

    private void verifyPage(WebElement link) throws Exception {
        String topic = link.getText();
        if (topic.toLowerCase().contains("patient portal"))
            return;
        if (topic.toLowerCase().contains("community events"))
            topic = "events";
        if (topic.toLowerCase().contains("directions & parking"))
            topic = "directions and parking";
        click(link);
        ExtentReport.getTest().log(Status.PASS,"Clicked on the link " + topic);
        Assertions.assertTrue(verifyTextPresent(By.tagName("h1"),topic),"The " + topic + " page is not broken","The " + topic + " page is broken");
        driver.navigate().back();
    }


}
