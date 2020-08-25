package practice.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Lib;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) {
        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("u_0_b"));

//        The implicit wait will tell to the web driver to wait for certain amount of time before it
//        throws a "No Such Element Exception".
//        The default setting is 0. Once we set the time, web driver will wait for that time before throwing an exception.

    }
}
