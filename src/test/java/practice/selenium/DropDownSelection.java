package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Lib;

import java.util.concurrent.TimeUnit;

public class DropDownSelection {
    public static void main(String[] args) {
        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("url");
        WebElement dropdownElement = driver.findElement(By.id("designation"));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(1);
        dropdown.selectByValue("dropdown1");
        dropdown.selectByVisibleText("dropdown");


        // Stale Element exception
        WebDriverWait wait = new WebDriverWait((WebDriver) dropdownElement, 10);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(dropdownElement)));


    }
}
