package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Lib;

import java.util.concurrent.TimeUnit;

public class ElementVisibilityTest {


    public static void main(String[] args) {
        System.setProperty("web.chrome.driver", Lib.getChromeDriverLocation());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://twitter.com/login?lang=en");


        //todo isDisplayed is used to check whether a particular element us displayed on the page and boolean value is returned
        boolean isLoginDisplayed = driver.findElement(By.xpath("//div[@class='someblah']")).isDisplayed();


        /*todo isEnabled is used to check whether a particular element is enabled on the page
         like click on Accept terms and conditions then only login button is enabled
         and boolean value is returned*/
        boolean isEnabled = driver.findElement(By.xpath("//div[@class='someblah']")).isEnabled();

        //todo isSelected to check whether a particular element is selected on the page used for checkbox, radiobutton,
        // dropdown and boolean value is returned
        boolean isSelected = driver.findElement(By.xpath("//div[@class='someblah']")).isSelected();
        System.out.println(isLoginDisplayed);


    }
}
