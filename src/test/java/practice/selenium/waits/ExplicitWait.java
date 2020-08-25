package practice.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Lib;

import java.io.IOException;

public class ExplicitWait {
    public static void main(String[] args) throws IOException {
/*
    1.The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions)
      or the maximum time exceeded before throwing an "ElementNotVisibleException" exception.
    2.Explicit wait gives better options than that of an implicit wait as it will wait
      for dynamically loaded Ajax elements.*/

        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("url");

            WebDriverWait wait = new WebDriverWait(driver, 20);
            // to get visibility of an element
            WebElement someElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/i")));
//            ExpectedConditions.stalenessOf();

            // to avoid StaleElementReferenceException
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table")));

            // to avoid StaleElementReferenceException by refreshing
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(someElement)));

            someElement.click();
        } catch (Exception e) {
            Lib.takeScreenShot(driver, ".src/test/resources/screenshots");


        }
    }
}
