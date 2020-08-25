package practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Lib;

import java.util.ArrayList;
import java.util.List;

public class CrossBrowserTesting {
    WebDriver driver;

    @Test
    public void cross_browser_testing() {

        List<String> stringList = new ArrayList<String>();
        stringList.add("sree");
    }

   /* @AfterMethod
    public void tearDown() {
        driver.close();
    }*/

    @BeforeTest
    @Parameters("browser")// passed from testNg.xml
    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
            driver = new ChromeDriver();
            System.out.println("ChromeDriver initialised");
        } else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
//            driver = new FirefoxDriver();
            System.out.println("FirefoxDriver initialised");
        } else if (browser.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
//            driver = new EdgeDriver();
            System.out.println("EdgeDriver initialised");
        }
    }
}
