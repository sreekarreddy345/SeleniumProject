package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Lib {

    public static String getChromeDriverLocation() {
        return "give ur path";
    }

    public static String getFireFoxDriverLocation() {
        return "give ur path";
    }

    public static void takeScreenShot(WebDriver driver, String path) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
//        FileUtils.copyFile(src,new File("src/test/resources"));

    }

    public static void getFluentWait(WebDriver driver, String value) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);


        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(By.xpath(value));
                element.sendKeys("#1YearForYSRCPMassVictory\n" +
                        "@ysjagan\n" +
                        "#1YearofByeByeBabu");
                return element;
            }
        });
        clickseleniumlink.click();
    }


}
