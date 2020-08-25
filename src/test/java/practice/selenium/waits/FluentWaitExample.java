package practice.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.Lib;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);


        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
            }
        });
        clickseleniumlink.click();

//       1. In the above example, we are declaring a fluent wait with the timeout of 30 seconds
//        and the frequency is set to 5 seconds by ignoring "NoSuchElementException"

//       2. We have created a new function to identify the Web Element on the page.
//        (Ex: Here Web Element is nothing but the selenium link on the webpage).

//       3. Frequency is set to 5 seconds and the maximum time is set to 30 seconds.
//          This means that it will check for the element on the web page at every 5 seconds for the maximum time of 30 seconds.
//          If the element is located within this time frame it will perform the operations else it will throw an" ElementNotVisibleException"

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        fluentWait.until(webDriver -> webDriver.findElement(By.className("")));

    }
}
