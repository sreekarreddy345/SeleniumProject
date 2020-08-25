package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Lib;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorExample {
    public static void main(String[] args) throws Exception {
        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String uri = "https://twitter.com/login?lang=en";
        driver.get(uri);

        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='session[username_or_email]']")).sendKeys("sreekarreddy345@gmail.com");

        WebElement passElement = driver.findElement(By.xpath("//input[@name='session[password]']"));
        passElement.sendKeys("SuShm@9294");
        WebElement loginElement = driver.findElement
                (By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']"));


        alertMessage(driver, "Message");
        clickOnElementUsingJS(driver, loginElement);
    }

    //  to create an alert message using JavaScriptExecutor
    public static void alertMessage(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + message + "')");
    }

    public static void clickOnElementUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
