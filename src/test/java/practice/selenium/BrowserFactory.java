package practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Lib;

public class BrowserFactory {


    static WebDriver driver;

    public static WebDriver startBrowser(String browser, String url) {

        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
            driver = new ChromeDriver();
        } else if ("ff".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", Lib.getFireFoxDriverLocation());
            driver = new FirefoxDriver();
        }
        driver.get(url);

        return driver;
    }

}
