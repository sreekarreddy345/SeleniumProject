package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Lib;

public class AmazonSignIn {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//span[.='Hello, Sign in']")).click();
    }

}
