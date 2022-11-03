import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void click(By element) {
        waitForElement(element).click();
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public WebElement waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean verifyTextPresent(By element, String text) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",waitForElement(element));
        minWait();
        return waitForElement(element).getText().toLowerCase().contains(text.toLowerCase());
    }

    private void minWait() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
