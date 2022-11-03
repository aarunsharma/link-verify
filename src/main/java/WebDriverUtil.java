import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Properties;

public class WebDriverUtil {

    private static WebDriver driver = null;

    private static WebDriver initialiseDriver() throws Exception {

        String browser = Config.getConfig("browser");

        switch (browser.toLowerCase()){
            case "chrome" : WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge" : WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default: throw new Exception("Browser Not supported");
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            return initialiseDriver();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}
